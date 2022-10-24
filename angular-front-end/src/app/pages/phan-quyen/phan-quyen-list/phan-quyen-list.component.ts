import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {NhomQuyenService} from "../../../shared/services/quan-ly-phan-quyen/api-service-implement/nhom-quyen.service";
import {QuanLyQuyenService} from "../../../shared/services/quan-ly-phan-quyen/api-service-implement/quan-ly-quyen.service";
import {MatDialog} from "@angular/material/dialog";
import {PhanQuyenFormComponent} from "../phan-quyen-form/phan-quyen-form.component";
import {Constants} from "../../../shared/Constants";
import {NhomQuyenMenuService} from "../../../shared/services/quan-ly-phan-quyen/api-service-implement/nhom-quyen-menu.service";
import {RightService} from "../../../shared/services/quan-ly-phan-quyen/api-service-implement/right.service";

@Component({
    selector: 'app-phan-quyen-list',
    templateUrl: './phan-quyen-list.component.html',
    styleUrls: ['./phan-quyen-list.component.scss']
})
export class PhanQuyenListComponent implements OnInit {

    title!: string;

    rights: any[] = [];
    quanLyQuyens: any[] = [];

    displayedColumns: string[] = ['tenChucNang', 'danhMuc', 'thaoTac', 'quyen'];
    displayedColumnQuyen: string[] = ['tenNhom'];
    dataSourceQuyen!: MatTableDataSource<any>;
    dataSource!: MatTableDataSource<any>;

    constructor(private nhomQuyenService: NhomQuyenService,
                private dialogService: MatDialog,
                private quanLyQuyenService: QuanLyQuyenService,
                private nhomQuyenMenuService: NhomQuyenMenuService,
                private rightService: RightService) {
    }

    ngOnInit(): void {
        this.getAllNhomQuyen();
        this.getAllNhomMenu();
    }

    openDiaLog(row: any) {
        const idNhomQuyenMenu = row.id;
        const idRight: any[] = [];
        this.quanLyQuyenService.getByQlqAndNhomQuyenMenu(row.id).subscribe({
            next: (data: any) => {
                for (const r of data) {
                    idRight.push(r.right.id);
                    this.quanLyQuyenService.idRight$.next(idRight)
                }
            }, error: (error) => {
                console.log(error);
            }
        })
        this.dialogService.open(PhanQuyenFormComponent,
            {
                width: '250px',
                height: '300px',
                data: {idRight, idNhomQuyenMenu}
            }).afterClosed().subscribe(result => {
            if (result === Constants.RESULT_CLOSE_DIALOG.SUCCESS) {
                this.getQuanLyQuyen();
            }
        });
    }

    getRight() {
        this.rightService.getAll().subscribe({
            next: (data: any) => {
                this.rights = data;
            }
        })
    }

    getQuanLyQuyen() {
        this.quanLyQuyenService.getAll().subscribe({
            next: (data: any) => {
                this.quanLyQuyens = data;
            }
        })
    }

    getAllNhomQuyen() {
        this.nhomQuyenService.getAll().subscribe({
            next: (data: any) => {
                this.dataSourceQuyen = new MatTableDataSource(data);
            }
        })
    }

    getAllNhomMenu() {
        this.getQuanLyQuyen();
        this.nhomQuyenMenuService.getAll().subscribe({
            next: (data: any) => {
                this.dataSource = new MatTableDataSource(data);
            }
        })
    }

    showDetail(id: number) {
        this.getRight();
        this.nhomQuyenService.getById(id).subscribe({
            next: (data: any) => {
                this.title = data.name;
            }
        })
        this.nhomQuyenMenuService.getById(id).subscribe({
            next: (data: any) => {
                this.dataSource = new MatTableDataSource<any>(data);
            }
        });
    }

    isRight(idNhomQuyenMenu: any, idRight: any) {
        for (const a of this.quanLyQuyens) {
            if (idNhomQuyenMenu == a.nhomQuyenMenu.id && idRight == a.right.id) {
                return true;
            }
        }
        return false;
    }
}

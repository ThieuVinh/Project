import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {Page} from "../../shared/model/page";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {BandocService} from "../../shared/services/quan-ly/bandoc.service";
import {ToastrService} from "ngx-toastr";
import {SachService} from "../../shared/services/quan-ly/sach.service";
import {TacgiaService} from "../../shared/services/quan-ly/tacgia.service";
import {NhaxuatbanService} from "../../shared/services/quan-ly/nhaxuatban.service";
import {data} from "autoprefixer";

@Component({
    selector: 'app-sach',
    templateUrl: './sach.component.html',
    styleUrls: ['./sach.component.scss']
})
export class SachComponent implements OnInit {

    displayedColumns: string[] = ['ma', 'ten', 'nhaXuatBan', 'tacGia', 'chuDe', 'namSanXuat', 'moTa', 'soLuongDangMuon', 'soLuongConLai', 'tongSoSach', 'hanhDong'];
    dataSource!: MatTableDataSource<any>;

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;
    tacGias!: any[];
    nhaXuatBans!: any[];

    formGroup = this.formBuider.group({
        id: [''],
        ma: ['', Validators.required],
        ten: ['', [Validators.required, Validators.minLength(6)]],
        nhaXuatBan: this.formBuider.group({
            id: ['', Validators.required]
        }),
        tacGia: this.formBuider.group({
            id: ['', Validators.required]
        }),
        chuDe: ['', Validators.required],
        namSanXuat: ['', Validators.required],
        moTa: [''],
        soLuongDangMuon: ['', Validators.required],
        soLuongConLai: ['', Validators.required],
        tongSoSach: ['', Validators.required]
    });

    constructor(private sachService: SachService,
                private tacGiaService: TacgiaService,
                private nhaXuatBanService: NhaxuatbanService,
                private formBuider: FormBuilder,
                private toastrService: ToastrService) {

    }

    ngOnInit(): void {
        this.getAlls();
        this.showTacGia();
        this.showNhaXuatBan();
    }

    getAlls() {
        this.sachService.getAll().subscribe({
            next: (data: any) => {
                this.dataSource = new MatTableDataSource(data);
                this.dataSource.paginator = this.paginator;
                this.dataSource.sort = this.sort;
            }, error: (error) => {
                console.log(error);
            }
        });
    }

    applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();

        if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
        }
    }

    showTacGia() {
        this.tacGiaService.getAll().subscribe(data => {
            this.tacGias = data as any[];
        })
    }

    showNhaXuatBan() {
        this.nhaXuatBanService.getAll().subscribe(data => {
            this.nhaXuatBans = data as any[];
        })
    }

    addSach() {
        this.formGroup.markAllAsTouched();
        if (this.formGroup.invalid) {
            return;
        }
        if (this.formGroup.getRawValue().id) {
            this.sachService.update(this.formGroup.getRawValue()).subscribe({
                next: () => {
                    this.toastrService.success(`Update Successfully`);
                    this.getAlls();
                }, error: (error) => {
                    this.toastrService.error(`Update Failed`);
                    console.log(error);
                }
            })
        } else {
            this.sachService.add(this.formGroup.getRawValue()).subscribe({
                next: () => {
                    this.toastrService.success(`Add Successfully`);
                    this.formGroup.reset();
                    this.getAlls();
                }, error: (error) => {
                    this.toastrService.error(`Add Failed`);
                    console.log(error);
                }
            });
        }
    }

    edit(row: any) {
        this.formGroup.patchValue(row);
        console.log(row)
    }

    delete(id: number) {
        this.sachService.delete(id).subscribe({
            next: () => {
                this.toastrService.success(`Delete Successfully`);
                this.formGroup.reset();
                this.getAlls();
            }, error: (error) => {
                this.toastrService.error(`Delete Failed`);
                console.log(error);
            }
        })
    }

}

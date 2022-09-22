import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MuonsachService} from "../../shared/services/quan-ly/muonsach.service";
import {SachService} from "../../shared/services/quan-ly/sach.service";
import {BandocService} from "../../shared/services/quan-ly/bandoc.service";
import {FormBuilder, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
    selector: 'app-muonsach',
    templateUrl: './muonsach.component.html',
    styleUrls: ['./muonsach.component.scss']
})
export class MuonsachComponent implements OnInit {

    displayedColumns: string[] = ['banDoc', 'sach', 'soLuong', 'ngayGioMuon', 'ngayGioTra', 'trangThai', 'ghiChu', 'hanhDong'];
    dataSource!: MatTableDataSource<any>;

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;
    sachs!: any[];
    banDocs!: any[];

    formGroup = this.formBuider.group({
        id: [''],
        banDoc: this.formBuider.group({
            id: ['', Validators.required]
        }),
        sach: this.formBuider.group({
            id: ['', Validators.required]
        }),
        soLuong: ['', Validators.required],
        ngayGioMuon: ['', Validators.required],
        ngayGioTra: ['', Validators.required],
        trangThai: ['', Validators.required],
        ghiChu: ['']
    })

    constructor(private muonsachService: MuonsachService,
                private sachService: SachService,
                private banDocService: BandocService,
                private formBuider: FormBuilder,
                private toastrService: ToastrService) {
    }

    ngOnInit(): void {
        this.getAlls();
        this.showSach();
        this.showBanDoc();
    }

    getAlls() {
        this.muonsachService.getAll().subscribe({
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

    showSach() {
        this.sachService.getAll().subscribe(data => {
            this.sachs = data as any[];
        })
    }

    showBanDoc() {
        this.banDocService.getAll().subscribe(data => {
            this.banDocs = data as any[];
        })
    }

    addMuonSach() {
        this.formGroup.markAllAsTouched();
        if (this.formGroup.invalid) {
            return;
        }
        if (this.formGroup.getRawValue().id) {
            this.muonsachService.update(this.formGroup.getRawValue()).subscribe({
                next: () => {
                    this.toastrService.success(`Update Successfully`);
                    this.getAlls();
                }, error: (error) => {
                    this.toastrService.error(`Update Failed`);
                    console.log(error);
                }
            })
        } else {
            console.log(this.formGroup.getRawValue());
            this.muonsachService.add(this.formGroup.getRawValue()).subscribe({
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
        this.muonsachService.delete(id).subscribe({
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

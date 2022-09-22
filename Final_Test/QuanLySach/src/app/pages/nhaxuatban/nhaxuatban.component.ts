import {Component, OnInit, ViewChild} from '@angular/core';
import {NhaxuatbanService} from "../../shared/services/quan-ly/nhaxuatban.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {FormBuilder, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
    selector: 'app-nhaxuatban',
    templateUrl: './nhaxuatban.component.html',
    styleUrls: ['./nhaxuatban.component.scss']
})
export class NhaxuatbanComponent implements OnInit {

    displayedColumns: string[] = ['ma', 'ten', 'trangThai', 'diaChi', 'moTa', 'hanhDong'];
    dataSource!: MatTableDataSource<any>;

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;

    formGroup = this.formBuider.group({
        id: [''],
        ma: ['', Validators.required],
        ten: ['', [Validators.required, Validators.minLength(6)]],
        trangThai: ['', Validators.required],
        diaChi: ['', Validators.required],
        moTa: ['']
    })

    constructor(private nhaXuatBanService: NhaxuatbanService,
                private formBuider: FormBuilder,
                private toastrService: ToastrService) {
    }

    ngOnInit(): void {
        this.getAlls();
    }

    getAlls() {
        this.nhaXuatBanService.getAll().subscribe({
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

    addNXB() {
        this.formGroup.markAllAsTouched();
        if (this.formGroup.invalid) {
            return;
        }
        if (this.formGroup.getRawValue().id) {
            this.nhaXuatBanService.update(this.formGroup.getRawValue()).subscribe({
                next: () => {
                    this.toastrService.success(`Update Successfully`);
                    this.getAlls();
                }, error: (error) => {
                    this.toastrService.error(`Update Failed`);
                    console.log(error);
                }
            })
        } else {
            this.nhaXuatBanService.add(this.formGroup.getRawValue()).subscribe({
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
    }

    delete(id: number) {
        this.nhaXuatBanService.delete(id).subscribe({
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

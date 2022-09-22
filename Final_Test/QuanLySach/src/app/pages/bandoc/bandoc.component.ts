import {Component, OnInit, ViewChild} from '@angular/core';
import {BandocService} from "../../shared/services/quan-ly/bandoc.service";
import {FormBuilder, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
    selector: 'app-bandoc',
    templateUrl: './bandoc.component.html',
    styleUrls: ['./bandoc.component.scss']
})
export class BandocComponent implements OnInit {

    displayedColumns: string[] = ['ma', 'ten', 'soDt', 'diaChi', 'ngaySinh', 'hang', 'hanhDong'];
    dataSource!: MatTableDataSource<any>;

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;

    formGroup = this.formBuider.group({
        id: [''],
        ma: ['', Validators.required],
        ten: ['', [Validators.required, Validators.minLength(6)]],
        soDt: ['', [Validators.required, Validators.pattern(/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/)]],
        diaChi: ['', [Validators.required, Validators.minLength(6)]],
        ngaySinh: ['', Validators.required],
        ngayTaoTaiKhoan: [new Date()],
        hang: ['', Validators.required]
    })

    constructor(private banDocService: BandocService,
                private formBuider: FormBuilder,
                private toastrService: ToastrService) {
    }

    ngOnInit(): void {
        this.getAlls();
    }

    getAlls() {
        this.banDocService.getAll().subscribe({
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

    addBanDoc() {
        this.formGroup.markAllAsTouched();
        if (this.formGroup.invalid) {
            return;
        }
        if (this.formGroup.getRawValue().id) {
            this.banDocService.update(this.formGroup.getRawValue()).subscribe({
                next: () => {
                    this.toastrService.success(`Update Successfully`);
                    this.getAlls();
                }, error: (error) => {
                    this.toastrService.error(`Update Failed`);
                    console.log(error);
                }
            })
        } else {
            this.banDocService.add(this.formGroup.getRawValue()).subscribe({
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
        this.banDocService.delete(id).subscribe({
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

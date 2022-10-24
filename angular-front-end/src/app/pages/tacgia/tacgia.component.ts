import {Component, OnInit, ViewChild} from '@angular/core';
import {TacgiaService} from "../../shared/services/quan-ly/tacgia.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {FormBuilder, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
    selector: 'app-tacgia.ts',
    templateUrl: './tacgia.component.html',
    styleUrls: ['./tacgia.component.scss']
})
export class TacgiaComponent implements OnInit {

    displayedColumns: string[] = ['ma', 'ten', 'soDt', 'diaChi', 'moTa', 'hanhDong'];
    dataSource!: MatTableDataSource<any>;

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;

    formGroup = this.formBuider.group({
        id: [''],
        ma: ['', Validators.required],
        ten: ['', [Validators.required, Validators.minLength(6)]],
        soDt: ['', [Validators.required, Validators.pattern(/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/)]],
        diaChi: ['', Validators.required],
        moTa: ['']
    })

    constructor(private tacGiaService: TacgiaService,
                private formBuider: FormBuilder,
                private toastrService: ToastrService) {
    }

    ngOnInit(): void {
        this.getAlls();
    }

    getAlls() {
        this.tacGiaService.getAll().subscribe({
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

    addTacGia() {
        this.formGroup.markAllAsTouched();
        if (this.formGroup.invalid) {
            return;
        }
        if (this.formGroup.getRawValue().id) {
            this.tacGiaService.update(this.formGroup.getRawValue()).subscribe({
                next: () => {
                    this.toastrService.success(`Update Successfully`);
                    this.getAlls();
                }, error: (error) => {
                    this.toastrService.error(`Update Failed`);
                    console.log(error);
                }
            })
        } else {
            this.tacGiaService.add(this.formGroup.getRawValue()).subscribe({
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
        this.tacGiaService.delete(id).subscribe({
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

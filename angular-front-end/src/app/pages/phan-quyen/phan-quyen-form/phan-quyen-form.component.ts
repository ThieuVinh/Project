import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup} from "@angular/forms";
import {RightService} from "../../../shared/services/quan-ly-phan-quyen/api-service-implement/right.service";
import {
    QuanLyQuyenService
} from "../../../shared/services/quan-ly-phan-quyen/api-service-implement/quan-ly-quyen.service";
import {
    NhomQuyenMenuService
} from "../../../shared/services/quan-ly-phan-quyen/api-service-implement/nhom-quyen-menu.service";
import {ToastrService} from "ngx-toastr";
import {Constants} from "../../../shared/Constants";

@Component({
    selector: 'app-phan-quyen-form',
    templateUrl: './phan-quyen-form.component.html',
    styleUrls: ['./phan-quyen-form.component.scss']
})
export class PhanQuyenFormComponent implements OnInit {

    temporaryId: any[] = []
    newId: any[] = [];
    listQuanLyQuyen: any[] = []
    idCu: any[] = []
    idMoi: any[] = []

    formGroup: FormGroup = this.fb.group({
        query: [false],
        insert: [false],
        update: [false],
        delete: [false],
        admin: [false]
    })

    constructor(private fb: FormBuilder,
                private rightService: RightService,
                private nhomQuyenMenuService: NhomQuyenMenuService,
                private quanLyQuyenService: QuanLyQuyenService,
                private matDialogRef: MatDialogRef<PhanQuyenFormComponent>,
                private toastService: ToastrService,
                @Inject(MAT_DIALOG_DATA) public data: any) {
    }

    ngOnInit(): void {
        this.getTemporatyId();
        this.quanLyQuyenService.idRight$.subscribe(data => {
            this.dataRight();
        })

    }

    onDismiss() {
        this.matDialogRef.close();
    }

    dataRight() {
        for (let i = 0; i < this.data.idRight.length; i++) {
            if (this.data.idRight[i] == 1) {
                this.formGroup.patchValue({query: true})
            }
            if (this.data.idRight[i] == 2) {
                this.formGroup.patchValue({insert: true})
            }
            if (this.data.idRight[i] == 3) {
                this.formGroup.patchValue({update: true})
            }
            if (this.data.idRight[i] == 4) {
                this.formGroup.patchValue({delete: true})
            }
            if (this.data.idRight[i] == 5) {
                this.formGroup.patchValue({admin: true})
            }
        }
    }

    onSubmit() {
        this.noSameElement(this.newId, this.data.idRight, this.idMoi)
        this.noSameElement(this.data.idRight, this.newId, this.idCu)

        // Xoa du lieu
        if (this.idCu.length > 0) {
            this.quanLyQuyenService.delete(this.data.idNhomQuyenMenu, this.idCu).subscribe((data: any) => {
                this.toastService.success('Lưu dữ liệu thành công !');
                this.matDialogRef.close(Constants.RESULT_CLOSE_DIALOG.SUCCESS);
            }, error => {
                console.log(error);
                this.toastService.error('Lưu dữ liệu thất bại !');

            })
        }

        // Them moi du lieu
        if (this.idMoi.length > 0) {
            this.add(this.idMoi);
            this.quanLyQuyenService.save(this.listQuanLyQuyen).subscribe((data: any) => {
                this.toastService.success('Lưu dữ liệu thành công !');
                this.matDialogRef.close(Constants.RESULT_CLOSE_DIALOG.SUCCESS);
            }, error => {
                console.log(error);
                this.toastService.error('Lưu dữ liệu thất bại !');

            })
        }

    }

    getTemporatyId() {
        this.quanLyQuyenService.getByQlqAndNhomQuyenMenu(this.data.idNhomQuyenMenu).subscribe((data: any) => {
            for (const d of data) {
                this.newId.push(d.right.id)
            }
            this.temporaryId = data;
        })
    }

    getIdSelected(id: number) {
        const index = this.newId.findIndex(f => f == id);
        if (index > -1) {
            this.newId.splice(index, 1);
        } else {
            this.newId.push(id);
        }
    }

    add(array: any) {
        for (const a of array) {
            this.listQuanLyQuyen.push({
                nhomQuyenMenu: {
                    id: this.data.idNhomQuyenMenu
                },
                right: {
                    id: a
                }
            })
        }
    }

    noSameElement(a: any, b: any, array: any) {
        for (const i in a) {
            let check = false;
            for (const j in b) {
                if (a[i] === b[j]) check = true;
            }
            if (!check) {
                array.push(a[i]);
            }
        }
    }
}

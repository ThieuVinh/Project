import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {PhanQuyenRoutingModule} from './phan-quyen-routing.module';
import {PhanQuyenListComponent} from './phan-quyen-list/phan-quyen-list.component';
import {PhanQuyenFormComponent} from './phan-quyen-form/phan-quyen-form.component';
import {SharedModule} from "../../shared/shared.module";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";
import {NgSelectModule} from "@ng-select/ng-select";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatCardModule} from "@angular/material/card";
import {MatDividerModule} from "@angular/material/divider";

@NgModule({
    declarations: [
        PhanQuyenListComponent,
        PhanQuyenFormComponent
    ],
    imports: [
        CommonModule,
        PhanQuyenRoutingModule,
        SharedModule,
        MatTableModule,
        MatPaginatorModule,
        MatFormFieldModule,
        MatCheckboxModule,
        MatDialogModule,
        MatInputModule,
        NgSelectModule,
        NgxDatatableModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        MatCardModule,
        MatDividerModule
    ],
    entryComponents: [PhanQuyenFormComponent]
})
export class PhanQuyenModule {
}

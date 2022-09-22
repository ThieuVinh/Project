import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MuonsachRoutingModule} from './muonsach-routing.module';
import {MuonsachComponent} from './muonsach.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {SharedModule} from "../../shared/shared.module";
import {MatRadioModule} from "@angular/material/radio";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {MatSelectModule} from "@angular/material/select";
import {MatNativeDateModule} from "@angular/material/core";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";

@NgModule({
    declarations: [
        MuonsachComponent
    ],
    imports: [
        CommonModule,
        MuonsachRoutingModule,
        MatFormFieldModule,
        ReactiveFormsModule,
        FormsModule,
        MatExpansionModule,
        MatInputModule,
        SharedModule,
        MatRadioModule,
        NgxDatatableModule,
        MatSelectModule,
        MatNativeDateModule,
        MatDatepickerModule,
        MatTableModule,
        MatPaginatorModule
    ]
})
export class MuonsachModule {
}

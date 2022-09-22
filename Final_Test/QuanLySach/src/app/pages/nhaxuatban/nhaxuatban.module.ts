import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NhaxuatbanRoutingModule } from './nhaxuatban-routing.module';
import { NhaxuatbanComponent } from './nhaxuatban.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {SharedModule} from "../../shared/shared.module";
import {MatRadioModule} from "@angular/material/radio";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {MatSelectModule} from "@angular/material/select";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";

@NgModule({
  declarations: [
    NhaxuatbanComponent
  ],
    imports: [
        CommonModule,
        NhaxuatbanRoutingModule,
        MatFormFieldModule,
        ReactiveFormsModule,
        FormsModule,
        MatExpansionModule,
        MatInputModule,
        SharedModule,
        MatRadioModule,
        NgxDatatableModule,
        MatSelectModule,
        MatTableModule,
        MatPaginatorModule
    ]
})
export class NhaxuatbanModule { }

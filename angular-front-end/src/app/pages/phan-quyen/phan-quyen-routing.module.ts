import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PhanQuyenListComponent} from "./phan-quyen-list/phan-quyen-list.component";

const routes: Routes = [{
    path: '',
    component: PhanQuyenListComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PhanQuyenRoutingModule { }

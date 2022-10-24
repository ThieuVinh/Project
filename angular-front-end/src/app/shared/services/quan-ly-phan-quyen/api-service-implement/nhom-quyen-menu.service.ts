import {Injectable} from '@angular/core';
import {ApiNhomQuyenMenuService} from "../api-service/api-nhom-quyen-menu.service";

@Injectable({
    providedIn: 'root'
})
export class NhomQuyenMenuService {

    constructor(private apiNhomQuyenMenu: ApiNhomQuyenMenuService) {
    }

    getAll() {
        return this.apiNhomQuyenMenu.getAll();
    }

    save(data: any) {
        return this.apiNhomQuyenMenu.save(data);
    }

    update(data: any) {
        return this.apiNhomQuyenMenu.update(data);
    }

    getById(id: number) {
        return this.apiNhomQuyenMenu.getById(id);
    }
}

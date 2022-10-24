import {Injectable} from '@angular/core';
import {ApiNhomQuyenService} from "../api-service/api-nhom-quyen.service";

@Injectable({
    providedIn: 'root'
})
export class NhomQuyenService {

    constructor(private apiNhomQuyen: ApiNhomQuyenService) {
    }

    getAll() {
        return this.apiNhomQuyen.getAll();
    }

    getById(id: number) {
        return this.apiNhomQuyen.getById(id);
    }

    save(data: any) {
        return this.apiNhomQuyen.save(data);
    }

    update(data: any) {
        return this.apiNhomQuyen.update(data);
    }
}

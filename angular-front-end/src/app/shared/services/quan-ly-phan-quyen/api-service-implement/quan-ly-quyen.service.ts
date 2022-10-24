import {Injectable} from '@angular/core';
import {ApiQuanLyQuyenService} from "../api-service/api-quan-ly-quyen.service";
import {BehaviorSubject} from "rxjs";
import {ApiService} from "../../api.service";

@Injectable({
    providedIn: 'root'
})
export class QuanLyQuyenService {

    constructor(private apiQuanLyQuyen: ApiQuanLyQuyenService) {
    }

    idRight$ = new BehaviorSubject<any>(0);

    getAll() {
        return this.apiQuanLyQuyen.getAll();
    }

    save(data: any) {
        return this.apiQuanLyQuyen.save(data);
    }

    update(data: any) {
        return this.apiQuanLyQuyen.update(data);
    }

    delete(id: any, idMang: any[]) {
        return this.apiQuanLyQuyen.delete(id, idMang);
    }

    getById(id: number) {
        return this.apiQuanLyQuyen.getById(id);
    }

    getByQlqAndNhomQuyenMenu(id: number) {
        return this.apiQuanLyQuyen.getByQlqAndNhomQuyenMenu(id);
    }
}

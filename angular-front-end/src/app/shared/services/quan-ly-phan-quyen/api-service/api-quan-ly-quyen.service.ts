import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ApiConstant} from "../../../constants/api-constant";
import {Observable} from "rxjs";
import {ApiService} from "../../api.service";

const httpOptions: any = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': 'Content-Type',
        'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
        // "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type,Accept, x-client-key, x-client-token, x-client-secret"
    })
};

@Injectable({
    providedIn: 'root'
})
export class ApiQuanLyQuyenService {

    constructor(private http: HttpClient,
                private apiService: ApiService) {
    }

    getAll() {
        return this.http.get(ApiConstant.quanLyQuyen, httpOptions);
    }

    save(data: any[]): Observable<any> {
        return this.http.post(ApiConstant.quanLyQuyen, data, httpOptions);
    }

    update(data: any): Observable<any> {
        return this.http.put(`${ApiConstant.quanLyQuyen}/${data.id}`, data, httpOptions);
    }

    delete(id: any, idMang: any[]) {
        return this.http.get(`${ApiConstant.quanLyQuyen}/deleteElement?id=${id}&idMang=${idMang}`, httpOptions);
    }

    getById(id: number) {
        return this.http.get(`${ApiConstant.quanLyQuyen}/quanly/${id}`, httpOptions);
    }

    getByQlqAndNhomQuyenMenu(id: number) {
        return this.http.get(`${ApiConstant.quanLyQuyen}/quanlyquyenbyid/${id}`, httpOptions);
    }
}

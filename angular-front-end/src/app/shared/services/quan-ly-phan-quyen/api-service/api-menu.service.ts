import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ApiConstant} from "../../../constants/api-constant";
import {Observable} from "rxjs";

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
export class ApiMenuService {

    constructor(private http: HttpClient) {
    }

    getAll() {
        return this.http.get(ApiConstant.menu, httpOptions);
    }

    save(data: any): Observable<any> {
        return this.http.post(ApiConstant.menu, data, httpOptions);
    }

    update(data: any): Observable<any> {
        return this.http.put(`${ApiConstant.menu}/${data.id}`, data, httpOptions);
    }

    delete(id: number): Observable<any> {
        return this.http.delete(`${ApiConstant.menu}/${id}`, httpOptions);
    }
}

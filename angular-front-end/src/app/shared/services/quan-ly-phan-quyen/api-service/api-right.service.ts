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
export class ApiRightService {

    constructor(private http: HttpClient) {
    }

    getAll() {
        return this.http.get(ApiConstant.right, httpOptions);
    }

    save(data: any): Observable<any> {
        return this.http.post(ApiConstant.right, data, httpOptions);
    }

    update(data: any): Observable<any> {
        return this.http.put(`${ApiConstant.right}/${data.id}`, data, httpOptions);
    }

    delete(id: number): Observable<any> {
        return this.http.delete(`${ApiConstant.right}/${id}`, httpOptions);
    }
}

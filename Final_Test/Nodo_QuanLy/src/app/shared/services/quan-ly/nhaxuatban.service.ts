import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NhaxuatbanService {

    url = 'http://localhost:8080/rest/nhaxuatban';

    constructor(private httpClient: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.httpClient.get(this.url);
    }

    getId(id: number): Observable<any> {
        return this.httpClient.get(this.url + '/' + id);
    }

    add(nhaXuatBan: any): Observable<any> {
        return this.httpClient.post(this.url, nhaXuatBan);
    }

    update(nhaXuatBan: any): Observable<any> {
        return this.httpClient.put(`${this.url}/${nhaXuatBan.id}`, nhaXuatBan);
    }

    delete(id: number): Observable<any> {
        return this.httpClient.delete(this.url + '/' + id);
    }
}

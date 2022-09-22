import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SachService {

    url = 'http://localhost:8080/rest/sach';

    constructor(private httpClient: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.httpClient.get(this.url);
    }

    getId(id: number): Observable<any> {
        return this.httpClient.get(this.url + '/' + id);
    }

    add(sach: any): Observable<any> {
        return this.httpClient.post(this.url, sach);
    }

    update(sach: any): Observable<any> {
        return this.httpClient.put(`${this.url}/${sach.id}`, sach);
    }

    delete(id: number): Observable<any> {
        return this.httpClient.delete(this.url + '/' + id);
    }
}

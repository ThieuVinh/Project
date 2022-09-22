import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MuonsachService {

    url = 'http://localhost:8080/rest/muonsach';

    constructor(private httpClient: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.httpClient.get(this.url);
    }

    getId(id: number): Observable<any> {
        return this.httpClient.get(this.url + '/' + id);
    }

    add(muonSach: any): Observable<any> {
        return this.httpClient.post(this.url, muonSach);
    }

    update(muonSach: any): Observable<any> {
        return this.httpClient.put(`${this.url}/${muonSach.id}`, muonSach);
    }

    delete(id: number): Observable<any> {
        return this.httpClient.delete(this.url + '/' + id);
    }
}

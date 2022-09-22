import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class BandocService {

    url = 'http://localhost:8080/rest/bandoc';

    constructor(private httpClient: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.httpClient.get(this.url);
    }

    getId(id: number): Observable<any> {
        return this.httpClient.get(this.url + '/' + id);
    }

    add(bandoc: any): Observable<any> {
        return this.httpClient.post(this.url, bandoc);
    }

    update(banDoc: any): Observable<any> {
        return this.httpClient.put(`${this.url}/${banDoc.id}`, banDoc);
    }

    delete(id: number): Observable<any> {
        return this.httpClient.delete(this.url + '/' + id);
    }
}

import {Injectable} from '@angular/core';
import {ApiRightService} from "../api-service/api-right.service";

@Injectable({
    providedIn: 'root'
})
export class RightService {

    constructor(private apiRight: ApiRightService) {
    }

    getAll() {
        return this.apiRight.getAll();
    }

    save(data: any) {
        return this.apiRight.save(data);
    }

    update(data: any) {
        return this.apiRight.update(data);
    }
}

import {Injectable} from '@angular/core';
import {ApiMenuService} from "../api-service/api-menu.service";

@Injectable({
    providedIn: 'root'
})
export class MenuService {

    constructor(private apiMenu: ApiMenuService) {
    }

    getAll() {
        return this.apiMenu.getAll();
    }

    save(data: any) {
        return this.apiMenu.save(data);
    }

    update(data: any) {
        return this.apiMenu.update(data);
    }
}

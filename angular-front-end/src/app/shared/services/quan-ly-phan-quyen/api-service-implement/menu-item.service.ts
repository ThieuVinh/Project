import {Injectable} from '@angular/core';
import {ApiMenuItemService} from "../api-service/api-menu-item.service";

@Injectable({
    providedIn: 'root'
})
export class MenuItemService {

    constructor(private apiMenuItem: ApiMenuItemService) {
    }

    getAll() {
        return this.apiMenuItem.getAll();
    }

    save(data: any) {
        return this.apiMenuItem.save(data);
    }

    update(data: any) {
        return this.apiMenuItem.update(data);
    }
}

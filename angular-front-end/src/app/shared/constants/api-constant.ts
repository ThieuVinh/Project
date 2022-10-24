import {environment} from "../../../environments/environment";

export const ApiConstant = {
    login: `${environment.service.authDomain}/api/login`,
    logout: `${environment.service.authDomain}/api/logout`,
    category: `${environment.service.apiDomain}/api/categories`,
    product: `${environment.service.apiDomain}/api/products`,

    menu: `${environment.service.localhost}/rest/menu`,
    menuItem: `${environment.service.localhost}/rest/menu-item`,
    nhomQuyen: `${environment.service.localhost}/rest/nhom-quyen`,
    nhomQuyenMenu: `${environment.service.localhost}/rest/nhom-quyen-menu`,
    quanLyQuyen: `${environment.service.localhost}/rest/quan-ly-quyen`,
    right: `${environment.service.localhost}/rest/right`,
};

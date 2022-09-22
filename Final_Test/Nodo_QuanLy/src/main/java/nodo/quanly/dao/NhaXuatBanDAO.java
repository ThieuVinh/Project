package nodo.quanly.dao;


import nodo.quanly.entities.NhaXuatBan;

import java.util.List;

public interface NhaXuatBanDAO {
    List<NhaXuatBan> getAll();

    NhaXuatBan getOne(Integer id);

    NhaXuatBan create(NhaXuatBan nhaXuatBan);

    NhaXuatBan update(NhaXuatBan nhaXuatBan);

    void delete(Integer id);
}

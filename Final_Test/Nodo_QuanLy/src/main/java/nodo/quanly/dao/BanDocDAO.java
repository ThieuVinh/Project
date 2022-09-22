package nodo.quanly.dao;

import nodo.quanly.entities.BanDoc;

import java.util.List;

public interface BanDocDAO {
    List<BanDoc> getAll();

    BanDoc getOne(Integer id);

    BanDoc create(BanDoc banDoc);

    BanDoc update(BanDoc banDoc);

    void delete(Integer id);
}

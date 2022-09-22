package nodo.quanly.dao;

import nodo.quanly.entities.Sach;

import java.util.List;

public interface SachDAO {
    List<Sach> getAll();
    Sach getOne(Integer id);

    Sach create(Sach sach);

    Sach update(Sach sach);

    void delete(Integer id);
}

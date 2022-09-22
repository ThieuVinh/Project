package nodo.quanly.dao;


import nodo.quanly.entities.TacGia;

import java.util.List;

public interface TacGiaDAO {
    List<TacGia> getAll();

    TacGia getOne(Integer id);

    TacGia create(TacGia tacGia);

    TacGia update(TacGia tacGia);

    void delete(Integer id);
}

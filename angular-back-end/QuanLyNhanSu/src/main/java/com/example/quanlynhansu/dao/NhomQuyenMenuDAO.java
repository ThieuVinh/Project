package com.example.quanlynhansu.dao;

import com.example.quanlynhansu.entity.NhomQuyenMenu;

import java.util.List;

public interface NhomQuyenMenuDAO {
    List<NhomQuyenMenu> getAll();

    NhomQuyenMenu getOne(Integer id);

    NhomQuyenMenu create(NhomQuyenMenu nhomQuyenMenu);

    NhomQuyenMenu update(NhomQuyenMenu nhomQuyenMenu);

    void delete(Integer id);
}

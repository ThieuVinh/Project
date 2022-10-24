package com.example.quanlynhansu.dao;

import com.example.quanlynhansu.entity.QuanLyQuyen;

import java.util.List;

public interface QuanLyQuyenDAO {
    List<QuanLyQuyen> getAll();

    List<QuanLyQuyen> getByIdQlqAndNQMM(Integer id);

    QuanLyQuyen getOne(Integer id);

    List<QuanLyQuyen> create(List<QuanLyQuyen> quanLyQuyen);

    QuanLyQuyen update(QuanLyQuyen quanLyQuyen);

    void delete(Integer id, Integer[] idMang);
}

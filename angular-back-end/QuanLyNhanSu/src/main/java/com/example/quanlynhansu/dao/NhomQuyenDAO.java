package com.example.quanlynhansu.dao;

import com.example.quanlynhansu.entity.NhomQuyen;

import java.util.List;

public interface NhomQuyenDAO {
    List<NhomQuyen> getAll();

    NhomQuyen getOne(Integer id);

    NhomQuyen create(NhomQuyen nhomQuyen);

    NhomQuyen update(NhomQuyen nhomQuyen);

    void delete(Integer id);
}

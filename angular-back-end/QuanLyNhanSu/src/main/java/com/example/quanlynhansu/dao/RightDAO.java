package com.example.quanlynhansu.dao;

import com.example.quanlynhansu.entity.Right;

import java.util.List;

public interface RightDAO {
    List<Right> getAll();

    Right getOne(Integer id);

    Right create(Right right);

    Right update(Right right);

    void delete(Integer id);
}

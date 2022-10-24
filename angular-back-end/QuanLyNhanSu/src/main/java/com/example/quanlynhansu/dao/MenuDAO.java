package com.example.quanlynhansu.dao;

import com.example.quanlynhansu.entity.Menu;

import java.util.List;

public interface MenuDAO {
    List<Menu> getAll();

    Menu getOne(Integer id);

    Menu create(Menu menu);

    Menu update(Menu menu);

    void delete(Integer id);
}

package com.example.quanlynhansu.dao;

import com.example.quanlynhansu.entity.MenuItem;

import java.util.List;

public interface MenuItemDAO {
    List<MenuItem> getAll();

    MenuItem getOne(Integer id);

    MenuItem create(MenuItem menuItem);

    MenuItem update(MenuItem menuItem);

    void delete(Integer id);
}

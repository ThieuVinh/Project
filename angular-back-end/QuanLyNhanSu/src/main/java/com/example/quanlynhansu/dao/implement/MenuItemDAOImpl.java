package com.example.quanlynhansu.dao.implement;

import com.example.quanlynhansu.dao.MenuItemDAO;
import com.example.quanlynhansu.entity.MenuItem;
import com.example.quanlynhansu.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuItemDAOImpl implements MenuItemDAO {

    @Autowired
    MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItem> getAll() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getOne(Integer id) {
        return menuItemRepository.findById(id).get();
    }

    @Override
    public MenuItem create(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem update(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void delete(Integer id) {
        menuItemRepository.deleteById(id);
    }
}

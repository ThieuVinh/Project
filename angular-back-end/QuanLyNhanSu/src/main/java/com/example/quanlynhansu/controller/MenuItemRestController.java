package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.dao.MenuItemDAO;
import com.example.quanlynhansu.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/menu-item")
public class MenuItemRestController {

    @Autowired
    MenuItemDAO menuItemDAO;

    @GetMapping()
    public List<MenuItem> getAll() {
        return menuItemDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public MenuItem getOne(@PathVariable("id") Integer id) {
        return menuItemDAO.getOne(id);
    }

    @PostMapping()
    public MenuItem create(@RequestBody MenuItem menuItem) {
        return menuItemDAO.create(menuItem);
    }

    @PutMapping(value = "/{id}")
    public MenuItem update(@PathVariable("id") Integer id, @RequestBody MenuItem menuItem) {
        return menuItemDAO.update(menuItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        menuItemDAO.delete(id);
    }
}

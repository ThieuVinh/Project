package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.dao.MenuDAO;
import com.example.quanlynhansu.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/menu")
public class MenuRestController {

    @Autowired
    MenuDAO menuDAO;

    @GetMapping()
    public List<Menu> getAll() {
        return menuDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public Menu getOne(@PathVariable("id") Integer id) {
        return menuDAO.getOne(id);
    }

    @PostMapping()
    public Menu create(@RequestBody Menu menu) {
        return menuDAO.create(menu);
    }

    @PutMapping(value = "/{id}")
    public Menu update(@PathVariable("id") Integer id, @RequestBody Menu menu) {
        return menuDAO.update(menu);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        menuDAO.delete(id);
    }
}

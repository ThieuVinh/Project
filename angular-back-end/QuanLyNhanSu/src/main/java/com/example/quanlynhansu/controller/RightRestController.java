package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.dao.RightDAO;
import com.example.quanlynhansu.entity.Right;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/right")
public class RightRestController {

    @Autowired
    RightDAO rightDAO;

    @GetMapping()
    public List<Right> getAll() {
        return rightDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public Right getOne(@PathVariable("id") Integer id) {
        return rightDAO.getOne(id);
    }

    @PostMapping()
    public Right create(@RequestBody Right right) {
        return rightDAO.create(right);
    }

    @PutMapping(value = "/{id}")
    public Right update(@PathVariable("id") Integer id, @RequestBody Right right) {
        return rightDAO.update(right);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        rightDAO.delete(id);
    }
}

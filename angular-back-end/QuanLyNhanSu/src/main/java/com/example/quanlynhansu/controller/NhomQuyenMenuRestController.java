package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.dao.NhomQuyenMenuDAO;
import com.example.quanlynhansu.entity.NhomQuyenMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/nhom-quyen-menu")
public class NhomQuyenMenuRestController {

    @Autowired
    NhomQuyenMenuDAO nhomQuyenMenuDAO;

    @GetMapping(value = "/{id}")
    public NhomQuyenMenu getOne(@PathVariable("id") Integer id) {
        return nhomQuyenMenuDAO.getOne(id);
    }

    @GetMapping()
    public List<NhomQuyenMenu> getAll() {
        return nhomQuyenMenuDAO.getAll();
    }

    @GetMapping(value = "/nhom/{id}")
    public List<NhomQuyenMenu> getById(@PathVariable("id") Integer id) {
        List<NhomQuyenMenu> nhomQuyenMenuList = nhomQuyenMenuDAO.getAll();
        for (int i = 0; i < nhomQuyenMenuList.size(); i++) {
            if(nhomQuyenMenuList.get(i).getNhomQuyen().getId() != id) {
                nhomQuyenMenuList.remove(i);
            }
        }
        return nhomQuyenMenuList;
    }

    @PostMapping()
    public NhomQuyenMenu create(@RequestBody NhomQuyenMenu nhomQuyenMenu)   {
        return nhomQuyenMenuDAO.create(nhomQuyenMenu);
    }

    @PutMapping(value = "/{id}")
    public NhomQuyenMenu update(@PathVariable("id") Integer id, @RequestBody NhomQuyenMenu nhomQuyenMenu) {
        return nhomQuyenMenuDAO.update(nhomQuyenMenu);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        nhomQuyenMenuDAO.delete(id);
    }
}

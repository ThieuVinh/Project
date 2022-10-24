package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.dao.QuanLyQuyenDAO;
import com.example.quanlynhansu.entity.QuanLyQuyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/quan-ly-quyen")
public class QuanLyQuyenRestController {

    @Autowired
    QuanLyQuyenDAO quanLyQuyenDAO;

    @GetMapping()
    public List<QuanLyQuyen> getAll() {
        return quanLyQuyenDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public QuanLyQuyen getOne(@PathVariable("id") Integer id) {
        return quanLyQuyenDAO.getOne(id);
    }

    @GetMapping(value = "/quanly/{id}")
    public List<QuanLyQuyen> getById(@PathVariable("id") Integer id) {
        List<QuanLyQuyen> quanLyQuyenList = quanLyQuyenDAO.getAll();
        for (int i = 0; i < quanLyQuyenList.size(); i++) {
            if(quanLyQuyenList.get(i).getNhomQuyenMenu().getNhomQuyen().getId() != id) {
                quanLyQuyenList.remove(i);
            }
        }
        return quanLyQuyenList;
    }

    @GetMapping(value = "/quanlyquyenbyid/{id}")
    public List<QuanLyQuyen> getByQlqAndNhomQuyenMenu(@PathVariable("id") Integer id) {
        return quanLyQuyenDAO.getByIdQlqAndNQMM(id);
    }

    @PostMapping()
    public List<QuanLyQuyen> create(@RequestBody List<QuanLyQuyen> quanLyQuyen) {
        return quanLyQuyenDAO.create(quanLyQuyen);
    }

    @PutMapping(value = "/{id}")
    public QuanLyQuyen update(@PathVariable("id") Integer id, @RequestBody QuanLyQuyen quanLyQuyen) {
        return quanLyQuyenDAO.update(quanLyQuyen);
    }

    @GetMapping(value = "/deleteElement")
    public void delete(@RequestParam("id") Integer id, @RequestParam("idMang") Integer[] idMang) {
        quanLyQuyenDAO.delete(id, idMang);
    }
}

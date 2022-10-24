package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.dao.NhomQuyenDAO;
import com.example.quanlynhansu.entity.NhomQuyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/nhom-quyen")
public class NhomQuyenRestController {

    @Autowired
    NhomQuyenDAO nhomQuyenDAO;

    @GetMapping()
    public List<NhomQuyen> getAll() {
        return nhomQuyenDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public NhomQuyen getOne(@PathVariable("id") Integer id) {
        return nhomQuyenDAO.getOne(id);
    }

    @PostMapping()
    public NhomQuyen create(@RequestBody NhomQuyen nhomQuyen) {
        return nhomQuyenDAO.create(nhomQuyen);
    }

    @PutMapping(value = "/{id}")
    public NhomQuyen update(@PathVariable("id") Integer id, @RequestBody NhomQuyen nhomQuyen) {
        return nhomQuyenDAO.update(nhomQuyen);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        nhomQuyenDAO.delete(id);
    }
}

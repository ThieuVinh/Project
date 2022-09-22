package nodo.quanly.controller;

import nodo.quanly.dao.SachDAO;
import nodo.quanly.dao.TacGiaDAO;
import nodo.quanly.entities.Sach;
import nodo.quanly.entities.TacGia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest/tacgia")
public class TacGiaRestController {

    @Autowired
    TacGiaDAO tacGiaDAO;

    @GetMapping()
    public List<TacGia> getAll() {
        return tacGiaDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public TacGia getOne(@PathVariable("id") Integer id) {
        return tacGiaDAO.getOne(id);
    }

    @PostMapping()
    public TacGia create(@RequestBody TacGia tacGia) {
        return tacGiaDAO.create(tacGia);
    }

    @PutMapping(value = "/{id}")
    public TacGia update(@PathVariable("id") Integer id, @RequestBody TacGia tacGia) {
        return tacGiaDAO.update(tacGia);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        tacGiaDAO.delete(id);
    }
}

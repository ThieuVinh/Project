package nodo.quanly.controller;

import nodo.quanly.dao.SachDAO;
import nodo.quanly.entities.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest/sach")
public class SachRestController {

    @Autowired
    SachDAO sachDAO;

    @GetMapping()
    public List<Sach> getAll() {
        return sachDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public Sach getOne(@PathVariable("id") Integer id) {
        return sachDAO.getOne(id);
    }

    @PostMapping()
    public Sach create(@RequestBody Sach sach) {
        return sachDAO.create(sach);
    }

    @PutMapping(value = "/{id}")
    public Sach update(@PathVariable("id") Integer id, @RequestBody Sach sach) {
        return sachDAO.update(sach);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        sachDAO.delete(id);
    }
}

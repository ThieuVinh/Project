package nodo.quanly.controller;

import nodo.quanly.dao.BanDocDAO;
import nodo.quanly.entities.BanDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest/bandoc")
public class BanDocRestController {

    @Autowired
    BanDocDAO banDocDAO;

    @GetMapping()
    public List<BanDoc> getAll() {
        return banDocDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public BanDoc getOne(@PathVariable("id") Integer id) {
        return banDocDAO.getOne(id);
    }

    @PostMapping()
    public BanDoc create(@RequestBody BanDoc banDoc) {
        return banDocDAO.create(banDoc);
    }

    @PutMapping(value = "/{id}")
    public BanDoc update(@PathVariable("id") Integer id, @RequestBody BanDoc banDoc) {
        return banDocDAO.update(banDoc);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        banDocDAO.delete(id);
    }
}

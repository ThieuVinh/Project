package nodo.quanly.controller;

import nodo.quanly.dao.MuonSachDAO;
import nodo.quanly.dao.SachDAO;
import nodo.quanly.entities.MuonSach;
import nodo.quanly.entities.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest/muonsach")
public class MuonSachRestController {

    @Autowired
    MuonSachDAO muonSachDAO;

    @GetMapping()
    public List<MuonSach> getAll() {
        return muonSachDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public MuonSach getOne(@PathVariable("id") Integer id) {
        return muonSachDAO.getOne(id);
    }

    @PostMapping()
    public MuonSach create(@RequestBody MuonSach muonSach) {
        return muonSachDAO.create(muonSach);
    }

    @PutMapping(value = "/{id}")
    public MuonSach update(@PathVariable("id") Integer id, @RequestBody MuonSach muonSach) {
        return muonSachDAO.update(muonSach);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        muonSachDAO.delete(id);
    }
}

package nodo.quanly.controller;

import nodo.quanly.dao.NhaXuatBanDAO;
import nodo.quanly.dao.SachDAO;
import nodo.quanly.entities.NhaXuatBan;
import nodo.quanly.entities.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/rest/nhaxuatban")
public class NhaXuatBanRestController {

    @Autowired
    NhaXuatBanDAO NhaXuatBanDAO;

    @GetMapping()
    public List<NhaXuatBan> getAll() {
        return NhaXuatBanDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public NhaXuatBan getOne(@PathVariable("id") Integer id) {
        return NhaXuatBanDAO.getOne(id);
    }

    @PostMapping()
    public NhaXuatBan create(@RequestBody NhaXuatBan nhaXuatBan) {
        return NhaXuatBanDAO.create(nhaXuatBan);
    }

    @PutMapping(value = "/{id}")
    public NhaXuatBan update(@PathVariable("id") Integer id, @RequestBody NhaXuatBan nhaXuatBan) {
        return NhaXuatBanDAO.update(nhaXuatBan);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        NhaXuatBanDAO.delete(id);
    }
}

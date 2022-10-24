package com.example.quanlynhansu.dao.implement;

import com.example.quanlynhansu.dao.NhomQuyenMenuDAO;
import com.example.quanlynhansu.entity.NhomQuyenMenu;
import com.example.quanlynhansu.repository.NhomQuyenMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NhomQuyenMenuDAOImpl implements NhomQuyenMenuDAO {

    @Autowired
    NhomQuyenMenuRepository nhomQuyenMenuRepository;

    @Override
    public List<NhomQuyenMenu> getAll() {
        return nhomQuyenMenuRepository.findAll();
    }

    @Override
    public NhomQuyenMenu getOne(Integer id) {
        return nhomQuyenMenuRepository.findById(id).get();
    }

    @Override
    public NhomQuyenMenu create(NhomQuyenMenu nhomQuyenMenu) {
        return nhomQuyenMenuRepository.save(nhomQuyenMenu);
    }

    @Override
    public NhomQuyenMenu update(NhomQuyenMenu nhomQuyenMenu) {
        return nhomQuyenMenuRepository.save(nhomQuyenMenu);
    }

    @Override
    public void delete(Integer id) {
        nhomQuyenMenuRepository.deleteById(id);
    }
}

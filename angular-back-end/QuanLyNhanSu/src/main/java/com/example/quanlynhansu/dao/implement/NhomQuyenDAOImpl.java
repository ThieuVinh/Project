package com.example.quanlynhansu.dao.implement;

import com.example.quanlynhansu.dao.NhomQuyenDAO;
import com.example.quanlynhansu.entity.NhomQuyen;
import com.example.quanlynhansu.repository.NhomQuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NhomQuyenDAOImpl implements NhomQuyenDAO {

    @Autowired
    NhomQuyenRepository nhomQuyenRepository;

    @Override
    public List<NhomQuyen> getAll() {
        return nhomQuyenRepository.findAll();
    }

    @Override
    public NhomQuyen getOne(Integer id) {
        return nhomQuyenRepository.findById(id).get();
    }

    @Override
    public NhomQuyen create(NhomQuyen nhomQuyen) {
        return nhomQuyenRepository.save(nhomQuyen);
    }

    @Override
    public NhomQuyen update(NhomQuyen nhomQuyen) {
        return nhomQuyenRepository.save(nhomQuyen);
    }

    @Override
    public void delete(Integer id) {
        nhomQuyenRepository.deleteById(id);
    }
}

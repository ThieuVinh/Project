package com.example.quanlynhansu.dao.implement;

import com.example.quanlynhansu.dao.QuanLyQuyenDAO;
import com.example.quanlynhansu.entity.QuanLyQuyen;
import com.example.quanlynhansu.repository.QuanLyQuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuanLyQuyenDAOImpl implements QuanLyQuyenDAO {

    @Autowired
    QuanLyQuyenRepository quanLyQuyenRepository;

    @Override
    public List<QuanLyQuyen> getAll() {
        return quanLyQuyenRepository.findAll();
    }

    @Override
    public List<QuanLyQuyen> getByIdQlqAndNQMM(Integer id) {
        return quanLyQuyenRepository.getByIdQlqAndNQMM(id);
    }

    @Override
    public QuanLyQuyen getOne(Integer id) {
        return quanLyQuyenRepository.findById(id).get();
    }

    @Override
    public List<QuanLyQuyen> create(List<QuanLyQuyen> quanLyQuyen) {
        return quanLyQuyenRepository.saveAll(quanLyQuyen);
    }

    @Override
    public QuanLyQuyen update(QuanLyQuyen quanLyQuyen) {
        return quanLyQuyenRepository.save(quanLyQuyen);
    }

    @Override
    public void delete(Integer id, Integer[] idMang) {
        for (Integer i : idMang) {
            this.quanLyQuyenRepository.deleteById(id, i);
        }
    }
}

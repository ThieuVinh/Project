package com.example.quanlynhansu.dao.implement;

import com.example.quanlynhansu.dao.RightDAO;
import com.example.quanlynhansu.entity.Right;
import com.example.quanlynhansu.repository.RightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RightDAOImpl implements RightDAO {

    @Autowired
    RightRepository rightRepository;

    @Override
    public List<Right> getAll() {
        return rightRepository.findAll();
    }

    @Override
    public Right getOne(Integer id) {
        return rightRepository.findById(id).get();
    }

    @Override
    public Right create(Right right) {
        return rightRepository.save(right);
    }

    @Override
    public Right update(Right right) {
        return rightRepository.save(right);
    }

    @Override
    public void delete(Integer id) {
        rightRepository.deleteById(id);
    }
}

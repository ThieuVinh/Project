package com.example.quanlynhansu.dao.implement;

import com.example.quanlynhansu.dao.MenuDAO;
import com.example.quanlynhansu.entity.Menu;
import com.example.quanlynhansu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuDAOImpl implements MenuDAO {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getOne(Integer id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void delete(Integer id) {
        menuRepository.deleteById(id);
    }
}

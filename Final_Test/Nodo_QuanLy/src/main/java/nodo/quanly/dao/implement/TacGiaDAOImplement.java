package nodo.quanly.dao.implement;

import nodo.quanly.dao.TacGiaDAO;
import nodo.quanly.entities.TacGia;
import nodo.quanly.repository.TacGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("tacGiaDAO")
public class TacGiaDAOImplement implements TacGiaDAO {

    @Autowired
    TacGiaRepository tacGiaRepository;

    @Override
    public List<TacGia> getAll() {
        return tacGiaRepository.findAll();
    }

    @Override
    public TacGia getOne(Integer id) {
        return tacGiaRepository.findById(id).get();
    }

    @Override
    public TacGia create(TacGia tacGia) {
        return tacGiaRepository.save(tacGia);
    }

    @Override
    public TacGia update(TacGia tacGia) {
        return tacGiaRepository.save(tacGia);
    }

    @Override
    public void delete(Integer id) {
        tacGiaRepository.deleteById(id);
    }
}

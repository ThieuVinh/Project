package nodo.quanly.dao.implement;

import nodo.quanly.dao.SachDAO;
import nodo.quanly.entities.Sach;
import nodo.quanly.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("sachDAO")
public class SachDAOImplement implements SachDAO {

    @Autowired
    SachRepository sachRepository;

    @Override
    public List<Sach> getAll() {
        return sachRepository.findAll();
    }

    @Override
    public Sach getOne(Integer id) {
        return sachRepository.findById(id).get();
    }

    @Override
    public Sach create(Sach sach) {
        return sachRepository.save(sach);
    }

    @Override
    public Sach update(Sach sach) {
        return sachRepository.save(sach);
    }

    @Override
    public void delete(Integer id) {
        sachRepository.deleteById(id);
    }
}

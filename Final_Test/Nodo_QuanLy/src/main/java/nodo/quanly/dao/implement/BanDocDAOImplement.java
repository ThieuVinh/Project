package nodo.quanly.dao.implement;

import nodo.quanly.dao.BanDocDAO;
import nodo.quanly.entities.BanDoc;
import nodo.quanly.repository.BanDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("banDocDAO")
public class BanDocDAOImplement implements BanDocDAO {

    @Autowired
    BanDocRepository banDocRepository;

    @Override
    public List<BanDoc> getAll() {
        return banDocRepository.findAll();
    }

    @Override
    public BanDoc getOne(Integer id) {
        return banDocRepository.findById(id).get();
    }

    @Override
    public BanDoc create(BanDoc banDoc) {
        return banDocRepository.save(banDoc);
    }

    @Override
    public BanDoc update(BanDoc banDoc) {
        return banDocRepository.save(banDoc);
    }

    @Override
    public void delete(Integer id) {
        banDocRepository.deleteById(id);
    }
}

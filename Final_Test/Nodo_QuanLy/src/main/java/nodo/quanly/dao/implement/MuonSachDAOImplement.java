package nodo.quanly.dao.implement;

import nodo.quanly.dao.MuonSachDAO;
import nodo.quanly.entities.MuonSach;
import nodo.quanly.repository.MuonSachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("muonSachDAO")
public class MuonSachDAOImplement implements MuonSachDAO {

    @Autowired
    MuonSachRepository muonSachRepository;

    @Override
    public List<MuonSach> getAll() {
        return muonSachRepository.findAll();
    }

    @Override
    public MuonSach getOne(Integer id) {
        return muonSachRepository.findById(id).get();
    }

    @Override
    public MuonSach create(MuonSach muonSach) {
        return muonSachRepository.save(muonSach);
    }

    @Override
    public MuonSach update(MuonSach muonSach) {
        return muonSachRepository.save(muonSach);
    }

    @Override
    public void delete(Integer id) {
        muonSachRepository.deleteById(id);
    }
}

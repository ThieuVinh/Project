package nodo.quanly.dao.implement;

import nodo.quanly.dao.NhaXuatBanDAO;
import nodo.quanly.entities.NhaXuatBan;
import nodo.quanly.repository.NhaXuatBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("nhaXuatBanDAO")
public class NhaXuatBanDAOImplement implements NhaXuatBanDAO {

    @Autowired
    NhaXuatBanRepository nhaXuatBanRepository;

    @Override
    public List<NhaXuatBan> getAll() {
        return nhaXuatBanRepository.findAll();
    }

    @Override
    public NhaXuatBan getOne(Integer id) {
        return nhaXuatBanRepository.findById(id).get();
    }

    @Override
    public NhaXuatBan create(NhaXuatBan nhaXuatBan) {
        return nhaXuatBanRepository.save(nhaXuatBan);
    }

    @Override
    public NhaXuatBan update(NhaXuatBan nhaXuatBan) {
        return nhaXuatBanRepository.save(nhaXuatBan);
    }

    @Override
    public void delete(Integer id) {
        nhaXuatBanRepository.deleteById(id);
    }
}

package nodo.quanly.dao;


import nodo.quanly.entities.MuonSach;

import java.util.List;

public interface MuonSachDAO {
    List<MuonSach> getAll();

    MuonSach getOne(Integer id);

    MuonSach create(MuonSach muonSach);

    MuonSach update(MuonSach muonSach);

    void delete(Integer id);
}

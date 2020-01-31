package com.AssetManagement.AssetManagement.service;

import com.AssetManagement.AssetManagement.dao.TowerDao;
import com.AssetManagement.AssetManagement.model.Tower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TowerService {
    private final TowerDao towerDao;

    @Autowired
    public TowerService(@Qualifier("postgres") TowerDao towerDao) {
        this.towerDao = towerDao;
    }

    public int addTower (Tower tower){
        return towerDao.insertTower(tower);
     }

     public List<Tower> getAllTower(){
        return towerDao.selectAllTower();
     }

     public Optional<Tower> getTowerById(UUID id){
        return towerDao.selectTowerById(id);
     }

     public int  deleteTower(UUID id){
        return towerDao.deleteTowerById(id);
     }

     public int updateTower(UUID id, Tower newTower){
        return towerDao.updateTowerById(id,newTower);
     }
}

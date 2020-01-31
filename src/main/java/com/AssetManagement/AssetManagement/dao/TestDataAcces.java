package com.AssetManagement.AssetManagement.dao;

import com.AssetManagement.AssetManagement.model.Tower;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("towerDao")
public class TestDataAcces implements TowerDao {

    private static List<Tower> DB = new ArrayList<>();

    @Override
    public int insertTower(UUID id, Tower tower) {
        DB.add(new Tower(id,tower.getBrand()));
        return 1;
    }

    @Override
    public List<Tower> selectAllTower() {
        return DB;
    }

    @Override
    public Optional<Tower> selectTowerById(UUID id) {
        return DB.stream()
                .filter(tower -> tower.getId().equals(id))
                .findAny();
    }

    @Override
    public int deleteTowerById(UUID id) {
        Optional<Tower> towerMaybe = selectTowerById(id);
        if (towerMaybe.isEmpty()){
            return 0;
        }
        DB.remove(towerMaybe.get());
        return 1;
    }

    @Override
    public int updateTowerById(UUID id, Tower towerUpdate) {
        return selectTowerById(id)
                .map(tower ->{
                    int indexOfTowerToUpdate= DB.indexOf(tower);
                    if (indexOfTowerToUpdate>=0){
                        DB.set(indexOfTowerToUpdate,new Tower(id,towerUpdate.getBrand()));
                        return 1;
                    }
                    return 0;
        })
                .orElse(0);
    }
}

package com.AssetManagement.AssetManagement.dao;

import com.AssetManagement.AssetManagement.model.Tower;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TowerDao {
    int insertTower(UUID id, Tower tower);
    default int insertTower(Tower tower){
        UUID id= UUID.randomUUID();
        return insertTower(id,tower);
    }

    List<Tower> selectAllTower();

    Optional<Tower> selectTowerById(UUID id);
    int deleteTowerById(UUID id);
    int updateTowerById (UUID id,Tower tower);

}

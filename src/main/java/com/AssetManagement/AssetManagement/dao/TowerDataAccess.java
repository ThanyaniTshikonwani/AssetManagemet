package com.AssetManagement.AssetManagement.dao;

import com.AssetManagement.AssetManagement.model.Tower;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class TowerDataAccess implements TowerDao {
    @Override
    public int insertTower(UUID id, Tower tower) {
        return 0;
    }

    @Override
    public List<Tower> selectAllTower() {
        return List.of(new Tower(UUID.randomUUID(),"From Postgres Datebase"));
    }

    @Override
    public Optional<Tower> selectTowerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteTowerById(UUID id) {
        return 0;
    }

    @Override
    public int updateTowerById(UUID id, Tower tower) {
        return 0;
    }
}

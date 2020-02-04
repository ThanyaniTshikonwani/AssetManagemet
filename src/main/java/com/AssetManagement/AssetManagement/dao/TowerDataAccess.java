package com.AssetManagement.AssetManagement.dao;

import com.AssetManagement.AssetManagement.model.Tower;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class TowerDataAccess implements TowerDao {

    private final JdbcTemplate jdbcTemplate;

    public TowerDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTower(UUID id , Tower tower) {
        String insertTowerSql = "INSERT INTO tower (id,brand) VALUES (?,?)";
        return jdbcTemplate.update ( insertTowerSql , id , tower.getBrandName () );
    }

    @Override
    public List<Tower> selectAllTower() {
        String sql = "SELECT id,brand FROM tower";
        return jdbcTemplate.query ( sql , mapTowerFromPostgresql () );
    }


    @Override
    public Optional<Tower> selectTowerById(UUID id) {

        return Optional.empty();
    }


    @Override
    public int deleteTowerById(UUID id) {
        String deleteTowerSql = "DELETE FROM tower WHERE id =?";
        return jdbcTemplate.update ( deleteTowerSql , id );
    }

    @Override
    public int updateTowerById(UUID id , Tower tower) {
        String updateTowersql = "UPDATE tower SET brandName =? WHERE id =?";
        return jdbcTemplate.update ( updateTowersql , id );
    }

    private RowMapper<Tower> mapTowerFromPostgresql() {
        return (resultSet , i) -> {
            String brand = resultSet.getString ( "brand" );
            UUID id = UUID.fromString ( resultSet.getString ( "id" ) );
            return new Tower ( id , brand );
        };
    }
}

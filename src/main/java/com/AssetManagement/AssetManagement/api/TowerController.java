package com.AssetManagement.AssetManagement.api;

import com.AssetManagement.AssetManagement.model.Tower;
import com.AssetManagement.AssetManagement.service.TowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("home/tower")
@RestController
public class TowerController {
    private final TowerService towerService;

    @Autowired
    public TowerController(TowerService towerService) {
        this.towerService = towerService;
    }

    @PostMapping()
    public  void addTower(@Valid @NonNull @RequestBody Tower tower){
        towerService.addTower(tower);
    }

    @GetMapping
    public List<Tower> getAllTower(){
        return  towerService.getAllTower();
    }

    @GetMapping(path = "{id}")
    public Tower getTowerById(@PathVariable("id") UUID id){
        return towerService.getTowerById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public  void deleteTowerById(@PathVariable("id") UUID id){
        towerService.deleteTower(id);
    }

    @PutMapping(path = "{id}")
    public void updateTowerById(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Tower towerToUpdate){
        towerService.updateTower(id,towerToUpdate);
    }
}

package com.AssetManagement.AssetManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Tower {
    public UUID getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    private final UUID id;
    private final String brand;

    public Tower(@JsonProperty("id") UUID id,@JsonProperty("name") String brand) {
        this.id = id;
        this.brand = brand;
    }


}

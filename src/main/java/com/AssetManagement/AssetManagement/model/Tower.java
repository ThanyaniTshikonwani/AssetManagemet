package com.AssetManagement.AssetManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Tower {
    public UUID getId() {
        return id;
    }

    @NotBlank
    private final String brandName;

    private final UUID id;

    public Tower(@JsonProperty("id") UUID id , @JsonProperty("name") String brand) {
        this.id = id;
        this.brandName = brand;

    }

    public String getBrandName() {
        return brandName;
    }


}

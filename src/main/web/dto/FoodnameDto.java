package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Food;


public class FoodnameDto {

    private final String name;

    public FoodnameDto(Food food) {
        this.name = food.getIntitule();
    }

    public String getName() {
        return name;
    }


}
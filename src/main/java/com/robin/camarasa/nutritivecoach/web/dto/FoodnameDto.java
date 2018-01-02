package com.robin.camarasa.nutritivecoach.web.dto;

import com.robin.camarasa.nutritivecoach.model.Food;


public class FoodnameDto {

    private final String name;

    public FoodnameDto(Food food) {
        this.name = food.getIntitule();
    }

    public String getName() {
        return name;
    }


}
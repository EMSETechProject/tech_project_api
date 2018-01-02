package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.model.FoodCooking;
import com.robin.camarasa.nutritvecoach.model.Recipe;

public class FoodCookingLightDto {

    private final Long id;
    private final Float weight;
    private final Food food;

    public FoodCookingLightDto(FoodCooking foodCooking) {
        this.id = foodCooking.getId();
        this.weight = foodCooking.getWeight();
        this.food = foodCooking.getFood();
    }

    public Float getWeight() {
        return weight;
    }

    public Food getFood() {
        return food;
    }

    public Long getId() {
        return id;
    }
}
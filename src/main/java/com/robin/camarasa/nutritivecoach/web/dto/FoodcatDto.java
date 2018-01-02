package com.robin.camarasa.nutritivecoach.web.dto;

import com.robin.camarasa.nutritivecoach.model.Food;


public class FoodcatDto {

    private final String cat;

    public FoodcatDto(Food food) {
        this.cat = food.getCategorie();
    }

    public String getCat() {
        return cat;
    }


}
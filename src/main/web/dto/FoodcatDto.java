package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;

import java.util.ArrayList;
import java.util.List;


public class FoodcatDto {

    private final String cat;

    public FoodcatDto(Food food) {
        this.cat = food.getCategorie();
    }

    public String getCat() {
        return cat;
    }


}
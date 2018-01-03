package com.robin.camarasa.nutritivecoach.web.dto;

import com.robin.camarasa.nutritivecoach.model.FoodCooking;
import com.robin.camarasa.nutritivecoach.model.Recipe;

import java.util.List;

public class TestDto {
    private Recipe recipe;
    private List<FoodCooking> foodCookings;

    public TestDto(Recipe recipe, List<FoodCooking> foodCookings) {
        this.recipe = recipe;
        this.foodCookings = foodCookings;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<FoodCooking> getFoodCookings() {
        return foodCookings;
    }

    public void setFoodCookings(List<FoodCooking> foodCookings) {
        this.foodCookings = foodCookings;
    }
}

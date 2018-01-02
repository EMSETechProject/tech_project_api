package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Recipe;

import java.util.List;

public class RecipeIngredientsDto {

    private final Long id;
    private final String name;
    private final Long type;
    private final List<FoodCookingLightDto> foodCookingLightDtos;

    public RecipeIngredientsDto(Recipe recipe, List<FoodCookingLightDto> foodCookingLightDtos) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.type = recipe.getType();
        this.foodCookingLightDtos = foodCookingLightDtos;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getType() {
        return type;
    }

    public List<FoodCookingLightDto> getFoodCookingLightDtos() {
        return foodCookingLightDtos;
    }
}
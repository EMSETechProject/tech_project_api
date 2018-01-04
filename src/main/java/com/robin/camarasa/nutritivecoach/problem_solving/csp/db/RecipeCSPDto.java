package com.robin.camarasa.nutritivecoach.problem_solving.csp.db;

import com.robin.camarasa.nutritivecoach.model.Food;
import com.robin.camarasa.nutritivecoach.model.FoodCooking;
import com.robin.camarasa.nutritivecoach.model.Recipe;

import java.util.List;

public class RecipeCSPDto {
    private Long id;
    private String name;
    private Long type;
    private Long numberOfIngredients;
    private Float calories;

    public RecipeCSPDto(Recipe recipe, List<FoodCooking> foodCookings, List<Food> foods) {
        id = recipe.getId();
        name = recipe.getName();
        type = recipe.getType();
        numberOfIngredients = (new Integer(foodCookings.size())).longValue();
        calories = 0f;
        for (int i = 0 ; i < foods.size() ; i++) {
            calories = calories + foods.get(i).getEnergie() * foodCookings.get(i).getWeight() / 100;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getNumberOfIngredients() {
        return numberOfIngredients;
    }

    public void setNumberOfIngredients(Long numberOfIngredients) {
        this.numberOfIngredients = numberOfIngredients;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }
}

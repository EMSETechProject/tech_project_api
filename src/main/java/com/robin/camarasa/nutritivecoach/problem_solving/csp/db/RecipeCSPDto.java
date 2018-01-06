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
    private Float lipides;
    private Float glucides;
    private Float fibres;
    private Float proteines;

    public RecipeCSPDto(Recipe recipe, List<FoodCooking> foodCookings, List<Food> foods) {
        id = recipe.getId();
        name = recipe.getName();
        type = recipe.getType();
        numberOfIngredients = (new Integer(foodCookings.size())).longValue();
        calories = 0f;
        lipides = 0f;
        glucides = 0f;
        fibres = 0f;
        proteines = 0f;
        for (int i = 0 ; i < foods.size() ; i++) {
            calories = calories + foods.get(i).getEnergie() * foodCookings.get(i).getWeight() / 100;
            lipides = lipides + foods.get(i).getLipides() * foodCookings.get(i).getWeight() / 100;
            glucides = glucides + foods.get(i).getGlucides() * foodCookings.get(i).getWeight() / 100;
            fibres = fibres + foods.get(i).getFibres() * foodCookings.get(i).getWeight() / 100;
            proteines = proteines + foods.get(i).getProteines_brutes() * foodCookings.get(i).getWeight() / 100;
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

    public Float getLipides() {
        return lipides;
    }

    public void setLipides(Float lipides) {
        this.lipides = lipides;
    }

    public Float getGlucides() {
        return glucides;
    }

    public void setGlucides(Float glucides) {
        this.glucides = glucides;
    }

    public Float getFibres() {
        return fibres;
    }

    public void setFibres(Float fibres) {
        this.fibres = fibres;
    }

    public Float getProteines() {
        return proteines;
    }

    public void setProteines(Float proteines) {
        this.proteines = proteines;
    }
}

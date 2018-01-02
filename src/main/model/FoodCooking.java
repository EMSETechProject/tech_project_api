package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SuppressWarnings("serial")
public class FoodCooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float weight;

    @ManyToOne
    private Food food;

    @ManyToOne
    private Recipe recipe;

    @SuppressWarnings("unused")
    public FoodCooking() {
    }

    public FoodCooking(Float weight, Food food, Recipe recipe) {
        this.weight = weight;
        this.food = food;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public Food getFood() {
        return food;
    }

    public Float getWeight() {
        return weight;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

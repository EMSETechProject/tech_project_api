package com.robin.camarasa.nutritivecoach.web.dto;

import com.robin.camarasa.nutritivecoach.model.Recipe;

public class RecipeDto {

    private final Long id;
    private final String name;
    private final Long type;

    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.type = recipe.getType();
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
}
package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.Preferences;

public class PreferencesDto {
    private Long id;
    private Long recipe_id;
    private Long user_id;

    public PreferencesDto(Preferences preferences) {
        this.id = preferences.getId();
        this.recipe_id = preferences.getRecipe().getId();
        this.user_id = preferences.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public Long getRecipe_id() {
        return recipe_id;
    }

    public Long getUser_id() {
        return user_id;
    }

}

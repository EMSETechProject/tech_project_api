package com.robin.camarasa.nutritivecoach.model;

import org.kie.api.definition.type.ClassReactive;

import javax.persistence.*;

@Entity
@ClassReactive
@SuppressWarnings("serial")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Recipe recipe;

    @Column(nullable = false)
    private Float value;



    @SuppressWarnings("unused")
    public Preferences() {
    }

    public Preferences(Float value, User user, Recipe recipe) {
        this.value = value;
        this.user = user;
        this.recipe = recipe;

    }

    public void setValue(Float value) {
        this.value = value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Float getValue() {
        return value;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Value : " + value + "\nUser : " + user.getPseudo() + "\nRecipe : " + recipe.getName();
    }
}

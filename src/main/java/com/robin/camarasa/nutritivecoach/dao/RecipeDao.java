package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<Recipe, Long> {
}
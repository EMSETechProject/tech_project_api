package com.robin.camarasa.nutritvecoach.dao;
import com.robin.camarasa.nutritvecoach.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<Recipe, Long> {
}
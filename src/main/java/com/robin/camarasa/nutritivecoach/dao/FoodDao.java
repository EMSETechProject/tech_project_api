package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDao extends JpaRepository<Food, Long> {
}
package com.robin.camarasa.nutritvecoach.dao;
import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.model.FoodCooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCookingDao extends JpaRepository<FoodCooking, Long> {
}
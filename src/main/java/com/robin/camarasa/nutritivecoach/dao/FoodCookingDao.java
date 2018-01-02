package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.FoodCooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCookingDao extends JpaRepository<FoodCooking, Long> {
}
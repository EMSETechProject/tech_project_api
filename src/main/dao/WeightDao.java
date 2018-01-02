package com.robin.camarasa.nutritvecoach.dao;
import com.robin.camarasa.nutritvecoach.model.Objectif;
import com.robin.camarasa.nutritvecoach.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightDao extends JpaRepository<Weight, Long> {
}
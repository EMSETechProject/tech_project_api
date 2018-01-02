package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightDao extends JpaRepository<Weight, Long> {
}
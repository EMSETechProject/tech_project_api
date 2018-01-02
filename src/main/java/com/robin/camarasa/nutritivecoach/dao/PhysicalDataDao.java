package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.PhysicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalDataDao extends JpaRepository<PhysicalData, Long> {
}
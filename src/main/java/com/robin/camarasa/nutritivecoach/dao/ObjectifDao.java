package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectifDao extends JpaRepository<Objectif, Long> {
}
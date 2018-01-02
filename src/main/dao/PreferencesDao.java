package com.robin.camarasa.nutritvecoach.dao;
import com.robin.camarasa.nutritvecoach.model.Objectif;
import com.robin.camarasa.nutritvecoach.model.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesDao extends JpaRepository<Preferences, Long> {
}
package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesDao extends JpaRepository<Preferences, Long> {
}
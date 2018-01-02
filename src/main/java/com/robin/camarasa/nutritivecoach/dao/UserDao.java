package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
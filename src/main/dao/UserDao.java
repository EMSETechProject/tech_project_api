package com.robin.camarasa.nutritvecoach.dao;
import com.robin.camarasa.nutritvecoach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
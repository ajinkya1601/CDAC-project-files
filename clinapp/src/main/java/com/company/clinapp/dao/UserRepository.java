package com.company.clinapp.dao;


import com.company.clinapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
   User findByUsername(String username);
}

package com.company.clinapp.dao;

import com.company.clinapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u.user_name from user u where u.user_name=:n")
     User findByUserName(String name);

}

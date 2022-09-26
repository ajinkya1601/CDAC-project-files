package com.company.clinapp.controller;

import com.company.clinapp.entity.User;
import com.company.clinapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) throws Exception {
        if (userService.isUsernamePresent(user)==true){
            throw new Exception("User with same username is already present!!!");
        }else return userService.save(user);
    }
}

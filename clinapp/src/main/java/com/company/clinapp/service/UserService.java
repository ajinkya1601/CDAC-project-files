package com.company.clinapp.service;

import com.company.clinapp.dao.UserRepository;
import com.company.clinapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public boolean isUsernamePresent(User user){
        if (userRepository.findByUsername(user.getUsername())!=null){
            if (userRepository.findByUsername(user.getUsername()).getUsername()!=null){
                return true;
            }else return false;
        }
        else return false;
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

    public User save(User user){
            user.setPassword(getEncodedPassword(user.getPassword()));
            return userRepository.save(user);
    }
}

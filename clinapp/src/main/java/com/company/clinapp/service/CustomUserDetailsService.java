package com.company.clinapp.service;

import com.company.clinapp.dao.UserRepository;
import com.company.clinapp.entity.CustomUserDetails;
import com.company.clinapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found !!");
        } else {
            return new CustomUserDetails(user);
        }
    }
}

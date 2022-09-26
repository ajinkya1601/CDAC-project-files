package com.company.clinapp.controller;

import com.company.clinapp.dao.UserRepository;
import com.company.clinapp.entity.JwtRequest;
import com.company.clinapp.entity.JwtResponse;
import com.company.clinapp.entity.User;
import com.company.clinapp.helper.JwtUtil;
import com.company.clinapp.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class JwtController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public JwtResponse generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//        System.out.println(jwtRequest);
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(),
                    jwtRequest.getPassword()
            ));
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad credential");
        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad credential");
        }
        UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token=jwtUtil.generateToken(userDetails);
//        System.out.println("JWT "+token);
        User user= userRepository.findByUsername(jwtRequest.getUsername());
        return new JwtResponse(user,token);
    }
}

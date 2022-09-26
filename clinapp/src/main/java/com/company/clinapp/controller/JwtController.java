package com.company.clinapp.controller;

import com.company.clinapp.entity.JwtRequest;
import com.company.clinapp.entity.JwtResponse;
import com.company.clinapp.service.CustomUserServiceDetails;
import com.company.clinapp.service.UserService;
import com.company.clinapp.utility.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class JwtController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private CustomUserServiceDetails userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public String generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUserName()
                            ,jwtRequest.getPassword()));
        }catch (Exception e){
            throw new Exception("Invalid Username or password");
        }
            return jwtTokenHelper.generateToken(jwtRequest.getUserName());
//    public ResponseEntity<JwtResponse> createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//        this.authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());
//
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUserName());
//        String token = this.jwtTokenHelper.generateToken(String.valueOf(userDetails));
//        JwtResponse response = new JwtResponse();
//        response.setJwtToken(token);
//        return new ResponseEntity<JwtResponse>(response, HttpStatus.OK);
    }

//    private void authenticate(String userName, String password) {
//
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                new UsernamePasswordAuthenticationToken(userName, password);
//        this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//    }
}

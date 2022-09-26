//package com.company.clinapp.service;
//
//import com.company.clinapp.dao.UserRepository;
//import com.company.clinapp.entity.JwtRequest;
//import com.company.clinapp.entity.JwtResponse;
//import com.company.clinapp.entity.User;
//import com.company.clinapp.utility.JwtTokenHelper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.Set;
//
//@Service
//public class JwtService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private JwtTokenHelper jwtUtil;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
//        String userName = jwtRequest.getUserName();
//        String password = jwtRequest.getPassword();
//        authenticate(userName, password);
//        final UserDetails userDetails = loadUserByUsername(userName);
//        String token = jwtUtil.generateToken(String.valueOf(userDetails));
//        User user = userRepository.findById(userName).get();
//        return new JwtResponse(user, token);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findById(username).get();
//
//        if (user != null) {
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUserName(),
//                    user.getPassword(),
//                    getAuthorities(user)
//            );
//        }else {
//            throw new UsernameNotFoundException("Username is not valid");
//        }
//    }
//
//    private Set getAuthorities(User user) {
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//    }
//
//
//    private void authenticate(String userName, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
//        } catch (DisabledException e) {
//            throw new Exception("User is disabled");
//        } catch (BadCredentialsException e) {
//            throw new Exception("Bad credentials");
//        }
//    }
//
//}

package com.cognizant.jwt_handson.controller;

import com.cognizant.jwt_handson.model.JwtRequest;
import com.cognizant.jwt_handson.model.JwtResponse;
import com.cognizant.jwt_handson.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest request) {


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );


        UserDetails userDetails =
                userDetailsService.loadUserByUsername(
                        request.getUsername()
                );


        String token = jwtUtil.generateToken(userDetails);


        return new JwtResponse(token);

    }
}
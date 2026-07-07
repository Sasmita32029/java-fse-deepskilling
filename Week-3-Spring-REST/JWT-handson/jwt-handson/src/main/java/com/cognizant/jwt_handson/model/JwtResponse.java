package com.cognizant.jwt_handson.model;


public class JwtResponse {

    private String token;


    public JwtResponse(String token) {
        this.token = token;
    }


    public String getToken() {
        return token;
    }
}
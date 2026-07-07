package com.cognizant.jwt_handson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwt_handson.model.Country;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public Country getCountry() {
        return new Country("IN", "India");
    }
}
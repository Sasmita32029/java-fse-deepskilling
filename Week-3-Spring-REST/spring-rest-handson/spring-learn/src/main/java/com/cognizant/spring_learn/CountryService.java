package com.cognizant.spring_learn;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private static List<Country> countryList = new ArrayList<>();

    static {
        Country india = new Country();
        india.setCode("IN");
        india.setName("India");

        Country us = new Country();
        us.setCode("US");
        us.setName("United States");

        Country uk = new Country();
        uk.setCode("UK");
        uk.setName("United Kingdom");

        countryList.add(india);
        countryList.add(us);
        countryList.add(uk);
    }

    public Country getCountry(String code) {

        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }
}
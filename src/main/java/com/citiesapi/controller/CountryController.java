package com.citiesapi.controller;

import com.citiesapi.entities.City;
import com.citiesapi.entities.Country;
import com.citiesapi.service.ServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    ServiceCountry service;

    @GetMapping
    public Page<Country> countries(Pageable page) {

        return service.getall(page);


    }
}

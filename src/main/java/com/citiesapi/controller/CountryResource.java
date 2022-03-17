package com.citiesapi.controller;

import com.citiesapi.model.Country;
import com.citiesapi.service.ServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryResource {
        @Autowired
        ServiceCountry service;

    @GetMapping
    public Page<Country> countries (Pageable page){

        return service.getall(page);
    }
    @GetMapping("/{id}")

    public Optional<Country> getOne(@PathVariable Long id){
        return service.findById(id);

    }



}

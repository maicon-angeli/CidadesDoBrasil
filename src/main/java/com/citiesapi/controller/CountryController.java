package com.citiesapi.controller;

import com.citiesapi.service.ServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    ServiceCountry service;




}

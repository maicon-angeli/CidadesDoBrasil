package com.citiesapi.controller;

import com.citiesapi.entities.City;
import com.citiesapi.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nearby")
public class NearbyController {
    @Autowired
    DistanceService service;

    @GetMapping
    public List<City> nearby(@RequestParam(name ="city_id")final Long cityId,
                             @RequestParam(name ="radius") final Double radius){
        return service.nearby(cityId,radius);
    }


}

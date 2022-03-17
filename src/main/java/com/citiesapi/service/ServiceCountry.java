package com.citiesapi.service;

import com.citiesapi.model.Country;
import com.citiesapi.repository.RepositoryCountry;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ServiceCountry {

   @Autowired
   RepositoryCountry repository;
    public Page<Country> getall(Pageable page) {
        return repository.findAll(page);
    }

    public Optional<Country> findById(Long id) {
        return repository.findById(id);
    }
}

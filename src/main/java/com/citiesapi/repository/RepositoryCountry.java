package com.citiesapi.repository;

import com.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryCountry extends JpaRepository<Country , Long> {
}

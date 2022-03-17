package com.citiesapi.repository;

import com.citiesapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RepositoryCountry extends JpaRepository<Country , Long> {
}

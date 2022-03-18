package com.citiesapi.service;

import com.citiesapi.entities.State;
import com.citiesapi.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StateService {
    @Autowired
    StateRepository repository;

    public Page<State> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public ResponseEntity findById(Long id) {
        Optional<State> optional = repository.findById(id);

        if(optional.isPresent())
        {
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}

package com.codeclan.example.pirateservice.controllers;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    //Find all the pirates
    @GetMapping(value="/pirates") //create the route
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    //Find pirate by ID
    @GetMapping(value="/pirates/{id}")
    public Optional<Pirate> getPirate(@PathVariable Long id){ // set optional and type of the object in case there is no object to return, if trying to return an id that doesn't exist will return null
        return pirateRepository.findById(id);
    }
}

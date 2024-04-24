package com.pixels.crudbackend.controllers;

import com.pixels.crudbackend.model.Persona;
import com.pixels.crudbackend.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/personas/")
public class PersonaREST {

    @Autowired
    private PersonaService service;

    @GetMapping()
    private ResponseEntity<Iterable<Persona>> getAllPersonas(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    private ResponseEntity<Persona> getPersona(@PathVariable("id") Long id){
        Optional<Persona> optPersona = service.findById(id);
        if(optPersona.isPresent()){
            Persona persona = optPersona.get();
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

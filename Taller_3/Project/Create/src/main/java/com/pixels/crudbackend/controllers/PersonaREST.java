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

    @PostMapping()
    private ResponseEntity<Persona> savePersona (@RequestBody Persona persona){

        try {

            Persona saved = service.save(persona);
            return ResponseEntity.created(new URI("/personas/"+saved.getId())).body(saved);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}

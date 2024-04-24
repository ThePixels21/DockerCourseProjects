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

    @DeleteMapping("eliminar/{id}")
    private ResponseEntity<Boolean> deletePersona (@PathVariable("id") Long id){
        this.service.deleteById(id);
        return ResponseEntity.ok(service.findById(id).isEmpty());
    }

}

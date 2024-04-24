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

    @PutMapping("editar/{id}")
    private ResponseEntity<Persona> updatePersona (@PathVariable("id") Long id, @RequestBody Persona persona){
        try{
            Optional<Persona> personaActual = service.findById(id);
            if(personaActual.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }else{
                persona.setId(id);
                Persona personaActualizada = service.save(persona);
                return ResponseEntity.ok(personaActualizada);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}

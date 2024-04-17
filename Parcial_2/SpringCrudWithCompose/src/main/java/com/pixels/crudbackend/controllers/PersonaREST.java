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

    @PostMapping()
    private ResponseEntity<Persona> savePersona (@RequestBody Persona persona){

        try {

            Persona saved = service.save(persona);
            return ResponseEntity.created(new URI("/personas/"+saved.getId())).body(saved);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("eliminar/{id}")
    private ResponseEntity<Boolean> deletePersona (@PathVariable("id") Long id){
        this.service.deleteById(id);
        return ResponseEntity.ok(service.findById(id).isEmpty());
    }

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

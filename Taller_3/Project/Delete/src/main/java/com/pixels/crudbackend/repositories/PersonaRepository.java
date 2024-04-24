package com.pixels.crudbackend.repositories;

import com.pixels.crudbackend.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
}

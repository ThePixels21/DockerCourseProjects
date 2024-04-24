package com.pixels.crudbackend.services;

import com.pixels.crudbackend.model.Persona;
import com.pixels.crudbackend.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService implements PersonaRepository{

    private PersonaRepository repo;

    public PersonaService(PersonaRepository repo){
        this.repo = repo;
    }

    @Override
    public <S extends Persona> S save(S entity) {
        return this.repo.save(entity);
    }

    @Override
    public <S extends Persona> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Persona> findById(Long aLong) {
        return this.repo.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Persona> findAll() {
        return this.repo.findAll();
    }

    @Override
    public Iterable<Persona> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return this.repo.count();
    }

    @Override
    public void deleteById(Long aLong) {
        this.repo.deleteById(aLong);
    }

    @Override
    public void delete(Persona entity) {
        this.repo.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Persona> entities) {

    }

    @Override
    public void deleteAll() {
        this.repo.deleteAll();
    }
}

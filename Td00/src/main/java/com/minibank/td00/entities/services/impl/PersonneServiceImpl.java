package com.minibank.td00.entities.services.impl;

import com.minibank.td00.entities.Personne;
import com.minibank.td00.entities.repositories.PersonneRepository;
import com.minibank.td00.entities.services.PersonneService;

import java.util.List;
import java.util.Optional;

public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public Personne create(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public Optional<Personne> readOne(Long id) {
        return personneRepository.findById(id);
    }

    @Override
    public List<Personne> readAll() {
        return personneRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        personneRepository.deleteById(id);
    }
}

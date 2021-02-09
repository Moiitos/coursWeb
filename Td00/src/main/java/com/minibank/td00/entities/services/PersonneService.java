package com.minibank.td00.entities.services;

import com.minibank.td00.entities.Personne;

import java.util.List;
import java.util.Optional;

public interface PersonneService {

    Personne create(Personne user);

    Optional<Personne> readOne(Long id);

    List<Personne> readAll();

    void delete(Long id);
}

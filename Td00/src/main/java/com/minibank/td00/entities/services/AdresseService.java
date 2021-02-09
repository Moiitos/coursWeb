package com.minibank.td00.entities.services;

import com.minibank.td00.entities.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseService {

    Adresse create(Adresse adresse);

    Optional<Adresse> readOne(Long id);

    List<Adresse> readAll();

    void delete(Long id);
}

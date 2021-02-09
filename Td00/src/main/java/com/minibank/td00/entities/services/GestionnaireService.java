package com.minibank.td00.entities.services;

import com.minibank.td00.entities.Gestionnaire;

import java.util.List;
import java.util.Optional;

public interface GestionnaireService {

    Gestionnaire create(Gestionnaire gestionnaire);

    Optional<Gestionnaire> readOne(Long id);

    List<Gestionnaire> readAll();

    void delete(Long id);
}

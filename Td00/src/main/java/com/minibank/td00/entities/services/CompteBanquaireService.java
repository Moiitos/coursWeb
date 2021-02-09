package com.minibank.td00.entities.services;

import com.minibank.td00.entities.CompteBanquaire;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface CompteBanquaireService {

    CompteBanquaire create(CompteBanquaire compte);

    Optional<CompteBanquaire> readOne(Long id);

    List<CompteBanquaire> readAll();

    void delete(Long id);
}

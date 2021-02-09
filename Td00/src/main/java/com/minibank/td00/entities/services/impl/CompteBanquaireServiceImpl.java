package com.minibank.td00.entities.services.impl;

import com.minibank.td00.entities.CompteBanquaire;
import com.minibank.td00.entities.Gestionnaire;
import com.minibank.td00.entities.repositories.CompteBanquaireRepository;
import com.minibank.td00.entities.services.CompteBanquaireService;

import java.util.List;
import java.util.Optional;

public class CompteBanquaireServiceImpl implements CompteBanquaireService {

    private final CompteBanquaireRepository compteBanquaireRepository;

    public CompteBanquaireServiceImpl(CompteBanquaireRepository compteBanquaireRepository) {
        this.compteBanquaireRepository = compteBanquaireRepository;
    }

    @Override
    public CompteBanquaire create(CompteBanquaire compteBanquaire) {
        return compteBanquaireRepository.save(compteBanquaire);
    }

    @Override
    public Optional<CompteBanquaire> readOne(Long id) {
        return compteBanquaireRepository.findById(id);
    }

    @Override
    public List<CompteBanquaire> readAll() {
        return compteBanquaireRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        compteBanquaireRepository.deleteById(id);
    }
}

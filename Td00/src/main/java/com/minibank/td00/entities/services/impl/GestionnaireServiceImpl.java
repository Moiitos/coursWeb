package com.minibank.td00.entities.services.impl;

import com.minibank.td00.entities.Gestionnaire;
import com.minibank.td00.entities.repositories.GestionnaireRepository;
import com.minibank.td00.entities.services.GestionnaireService;

import java.util.List;
import java.util.Optional;

public class GestionnaireServiceImpl implements GestionnaireService {

    private final GestionnaireRepository gestionnaireRepository;

    public GestionnaireServiceImpl(GestionnaireRepository gestionnaireRepository) {
        this.gestionnaireRepository = gestionnaireRepository;
    }

    @Override
    public Gestionnaire create(Gestionnaire gestionnaire) {
        return gestionnaireRepository.save(gestionnaire);
    }

    @Override
    public Optional<Gestionnaire> readOne(Long id) {
        return gestionnaireRepository.findById(id);
    }

    @Override
    public List<Gestionnaire> readAll() {
        return gestionnaireRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        gestionnaireRepository.deleteById(id);
    }
}

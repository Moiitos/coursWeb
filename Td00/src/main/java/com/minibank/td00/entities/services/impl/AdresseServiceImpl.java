package com.minibank.td00.entities.services.impl;

import com.minibank.td00.entities.Adresse;
import com.minibank.td00.entities.repositories.AdresseRepository;
import com.minibank.td00.entities.services.AdresseService;

import java.util.List;
import java.util.Optional;

public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;

    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public Adresse create(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Optional<Adresse> readOne(Long id) {
        return adresseRepository.findById(id);
    }

    @Override
    public List<Adresse> readAll() {
        return adresseRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        adresseRepository.deleteById(id);
    }
}

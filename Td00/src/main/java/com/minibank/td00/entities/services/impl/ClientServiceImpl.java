package com.minibank.td00.entities.services.impl;

import com.minibank.td00.entities.Client;
import com.minibank.td00.entities.repositories.ClientRepository;
import com.minibank.td00.entities.services.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> readOne(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}

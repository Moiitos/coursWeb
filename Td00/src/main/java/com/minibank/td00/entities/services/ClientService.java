package com.minibank.td00.entities.services;

import com.minibank.td00.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client create(Client client);

    Optional<Client> readOne(Long id);

    List<Client> readAll();

    void delete(Long id);
}

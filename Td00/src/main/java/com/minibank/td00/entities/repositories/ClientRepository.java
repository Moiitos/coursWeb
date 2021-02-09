package com.minibank.td00.entities.repositories;

import com.minibank.td00.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

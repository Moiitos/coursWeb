package com.minibank.td00.entities.repositories;

import com.minibank.td00.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}

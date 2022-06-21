package com.RomainP01.boulangeriesimulator.repositories;

import com.RomainP01.boulangeriesimulator.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
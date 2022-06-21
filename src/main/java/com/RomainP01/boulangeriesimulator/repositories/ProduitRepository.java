package com.RomainP01.boulangeriesimulator.repositories;

import com.RomainP01.boulangeriesimulator.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}

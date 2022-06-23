package com.RomainP01.boulangeriesimulator.services;

import com.RomainP01.boulangeriesimulator.model.Produit;
import com.RomainP01.boulangeriesimulator.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(int id) {
        return produitRepository.findById(id);
    }

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteById(int id) {
        produitRepository.deleteById(id);
    }
}

package com.RomainP01.boulangeriesimulator.services;

import com.RomainP01.boulangeriesimulator.model.Commande;
import com.RomainP01.boulangeriesimulator.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    public List<Commande> getAllCommands() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommandById(int id) {
        return commandeRepository.findById(id);
    }

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    public void deleteById(int id) {
        commandeRepository.deleteById(id);
    }
}
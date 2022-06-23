package com.RomainP01.boulangeriesimulator.controller;

import com.RomainP01.boulangeriesimulator.model.Client;
import com.RomainP01.boulangeriesimulator.model.Commande;
import com.RomainP01.boulangeriesimulator.services.ClientService;
import com.RomainP01.boulangeriesimulator.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoulangerieController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private CommandeService commandeService;
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Optional<Client> getClientById(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }

    @PostMapping(value="/clients")
    public Client addClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping(value="/clients/{id}")
    public Client updateClient(@PathVariable("id") int id, @RequestBody Client client) {
        Client clt = clientService.getClientById(id)
                .orElseThrow(()->new RuntimeException("Client with "+id+" is not found!"));
        clt.setNom(client.getNom());
        clt.setPrenom(client.getPrenom());
        clt.setTelephone(client.getTelephone());
        return clientService.save(clt);
    }

    @DeleteMapping(value="/clients/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        Client clt = clientService.getClientById(id)
                .orElseThrow(()->new RuntimeException("Client with "+id+" is not found!"));
        clientService.deleteById(clt.getId());
        return "Client "+id+" has been deleted";
    }

    @GetMapping("/commandes")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommands();
    }

    @GetMapping("/commandes/{id}")
    public Optional<Commande> getCommandById(@PathVariable("id") int id) {
        return commandeService.getCommandById(id);
    }

    @PostMapping(value="/commandes")
    public Commande addCommand(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @PutMapping(value="/commandes/{id}")
    public Commande updateCommande(@PathVariable("id") int id, @RequestBody Commande commande) {
        Commande cmd = commandeService.getCommandById(id)
                .orElseThrow(()->new RuntimeException("Command with "+id+" is not found!"));
        cmd.setClient(commande.getClient());
        cmd.setProduits(commande.getProduits());
        cmd.setDate(commande.getDate());
        cmd.setHeure(commande.getHeure());
        return commandeService.save(cmd);
    }

    @DeleteMapping(value="/commandes/{id}")
    public String deleteCommande(@PathVariable("id") int id) {
        Commande cmd = commandeService.getCommandById(id)
                .orElseThrow(()->new RuntimeException("Command with "+id+" is not found!"));
        commandeService.deleteById(cmd.getId());
        return "Command "+id+" has been deleted";
    }
}
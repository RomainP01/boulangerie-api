package com.RomainP01.boulangeriesimulator.controller;

import com.RomainP01.boulangeriesimulator.model.Client;
import com.RomainP01.boulangeriesimulator.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoulangerieController {
    @Autowired
    private ClientService clientService;

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
}
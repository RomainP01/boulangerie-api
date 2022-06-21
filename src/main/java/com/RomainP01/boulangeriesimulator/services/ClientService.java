package com.RomainP01.boulangeriesimulator.services;

import com.RomainP01.boulangeriesimulator.model.Client;
import com.RomainP01.boulangeriesimulator.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }
}

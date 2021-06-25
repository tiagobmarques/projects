package com.banking.client.core.client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getListClient() {
        return repository.findAll();
    }

    public Optional<Client> getClientById(UUID id){
        return repository.findById(id);
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
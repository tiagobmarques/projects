package com.banking.client.core.client;

import java.util.List;

public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getListClient() {
        return repository.findAll();
    }

}
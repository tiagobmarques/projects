package com.banking.client.core.client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {

    List<Client> findAll();

    Optional<Client> findById(UUID id);

    Client save(Client client);

    void deleteById(UUID id);
}

package com.banking.client.infrastructure.client;

import com.banking.client.core.client.Client;
import com.banking.client.core.client.ClientRepository;
import com.banking.client.infrastructure.client.postgresql.ClientEntity;
import com.banking.client.infrastructure.client.postgresql.ClientPostgresqlRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientRepositoryBridge implements ClientRepository {

    private final ClientPostgresqlRepository repository;
    private final ClientMapper mapper;

    public ClientRepositoryBridge(ClientPostgresqlRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Client> findAll() {
        List<ClientEntity> clients = repository.findAll();

        return clients.stream()
                .map(mapper::toClass)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toClass);
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = repository.save(mapper.toEntity(client));
        return mapper.toClass(clientEntity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

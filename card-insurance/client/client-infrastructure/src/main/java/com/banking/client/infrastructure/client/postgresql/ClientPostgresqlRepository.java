package com.banking.client.infrastructure.client.postgresql;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface ClientPostgresqlRepository extends PagingAndSortingRepository<ClientEntity, UUID> {

    List<ClientEntity> findAll();
}
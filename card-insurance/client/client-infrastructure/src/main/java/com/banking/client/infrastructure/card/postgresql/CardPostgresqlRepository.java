package com.banking.client.infrastructure.card.postgresql;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface CardPostgresqlRepository extends PagingAndSortingRepository<CardEntity, UUID> {

    List<CardEntity> findAll();
}
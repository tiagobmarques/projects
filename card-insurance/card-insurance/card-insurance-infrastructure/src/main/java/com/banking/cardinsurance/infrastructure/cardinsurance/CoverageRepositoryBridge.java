package com.banking.cardinsurance.infrastructure.cardinsurance;

import com.banking.cardinsurance.core.cardinsurance.Coverage;
import com.banking.cardinsurance.core.cardinsurance.CoverageRepository;
import com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb.CoverageDynamoDBRepository;
import com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb.CoverageEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CoverageRepositoryBridge implements CoverageRepository {

    private final CoverageDynamoDBRepository repository;
    private final CoverageMapper mapper;

    public CoverageRepositoryBridge(CoverageDynamoDBRepository repository, CoverageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Coverage> findAll() {
        List<CoverageEntity> cards = repository.findAll();

        return cards.stream()
                .map(mapper::toClass)
                .collect(Collectors.toList());
    }
}

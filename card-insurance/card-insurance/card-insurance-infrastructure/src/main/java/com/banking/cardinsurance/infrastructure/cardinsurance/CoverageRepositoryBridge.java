package com.banking.cardinsurance.infrastructure.cardinsurance;

import com.banking.cardinsurance.core.cardinsurance.Coverage;
import com.banking.cardinsurance.core.cardinsurance.CoverageRepository;
import com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb.CoverageDynamoDBRepository;
import com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb.CoverageEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    @Override
    public Coverage save(Coverage coverage) {
        CoverageEntity save = repository.save(mapper.toEntity(coverage));
        return mapper.toClass(save);
    }

    @Override
    public Optional<Coverage> findById(UUID id) {
        Optional<CoverageEntity> coverageEntity = repository.findById(id.toString());
        return coverageEntity.map(mapper::toClass);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id.toString());
    }
}

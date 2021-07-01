package com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface CoverageDynamoDBRepository extends CrudRepository<CoverageEntity, String> {

    List<CoverageEntity> findAll();
}
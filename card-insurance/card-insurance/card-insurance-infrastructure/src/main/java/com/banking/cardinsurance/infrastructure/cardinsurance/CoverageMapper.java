package com.banking.cardinsurance.infrastructure.cardinsurance;

import com.banking.cardinsurance.core.cardinsurance.Coverage;
import com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb.CoverageEntity;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CoverageMapper {
    public Coverage toClass(CoverageEntity coverageEntity) {

        return Coverage.builder()
                .id(coverageEntity.getId() != null ? UUID.fromString(coverageEntity.getId()) : null)
                .description(coverageEntity.getDescription())
                .value(coverageEntity.getValue())
                .build();
    }

    public CoverageEntity toEntity(Coverage coverage) {
        return CoverageEntity.builder()
                .id(coverage.getId() != null ? coverage.getId().toString() : null)
                .description(coverage.getDescription())
                .value(coverage.getValue())
                .build();
    }
}

package com.banking.cardinsurance.infrastructure.cardinsurance;

import com.banking.cardinsurance.core.cardinsurance.Coverage;
import com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb.CoverageEntity;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CoverageMapper {
    public Coverage toClass(CoverageEntity coverageEntity) {
        return Coverage.builder()
                .id(UUID.fromString(coverageEntity.getId()))
                .description(coverageEntity.getDescription())
                .value(coverageEntity.getValue())
                .build();
    }
}

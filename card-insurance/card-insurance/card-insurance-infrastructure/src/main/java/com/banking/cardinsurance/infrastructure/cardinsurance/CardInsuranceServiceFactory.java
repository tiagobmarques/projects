package com.banking.cardinsurance.infrastructure.cardinsurance;

import com.banking.cardinsurance.core.cardinsurance.CardInsuranceService;
import com.banking.cardinsurance.core.cardinsurance.CoverageRepository;
import com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb.CoverageDynamoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardInsuranceServiceFactory {

    private final CoverageDynamoDBRepository coverageDynamoDBRepository;
    private final CoverageMapper coverageMapper;

    @Autowired
    public CardInsuranceServiceFactory(CoverageDynamoDBRepository coverageDynamoDBRepository,
                                       CoverageMapper coverageMapper) {
        this.coverageDynamoDBRepository = coverageDynamoDBRepository;
        this.coverageMapper = coverageMapper;
    }

    @Bean
    @Autowired
    public CardInsuranceService createCardInsuranceService(CoverageRepository repository) {
        return new CardInsuranceService(repository);
    }

    @Bean
    public CoverageRepository createCoverageRepository() {
        return new CoverageRepositoryBridge(this.coverageDynamoDBRepository, this.coverageMapper);
    }

}


package com.banking.cardinsurance.core.cardinsurance;

import java.util.List;

public class CardInsuranceService {

    private final CoverageRepository coverageRepository;

    public CardInsuranceService(CoverageRepository coverageRepository) {
        this.coverageRepository = coverageRepository;
    }

    public List<Coverage> findAllCoverages() {
        return coverageRepository.findAll();
    }

    public Coverage save(Coverage coverage) {
        return coverageRepository.save(coverage);
    }
}

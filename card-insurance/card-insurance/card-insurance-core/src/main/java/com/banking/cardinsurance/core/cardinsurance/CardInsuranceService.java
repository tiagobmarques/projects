package com.banking.cardinsurance.core.cardinsurance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CardInsuranceService {

    private final CoverageRepository coverageRepository;

    public CardInsuranceService(CoverageRepository coverageRepository) {
        this.coverageRepository = coverageRepository;
    }

    public List<Coverage> findAllCoverages() {
        return coverageRepository.findAll();
    }

    public Optional<Coverage> findCoverageById(UUID id) {
        return coverageRepository.findById(id);
    }

    public Coverage saveCoverage(Coverage coverage) {
        return coverageRepository.save(coverage);
    }

    public void deleteCoverage(UUID id) {
        coverageRepository.deleteById(id);
    }
}

package com.banking.cardinsurance.core.cardinsurance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoverageRepository {

    List<Coverage> findAll();

    Coverage save(Coverage coverage);

    Optional<Coverage> findById(UUID id);

    void deleteById(UUID id);
}

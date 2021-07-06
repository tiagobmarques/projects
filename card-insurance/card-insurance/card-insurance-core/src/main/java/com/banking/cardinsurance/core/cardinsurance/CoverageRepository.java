package com.banking.cardinsurance.core.cardinsurance;

import java.util.List;

public interface CoverageRepository {

    List<Coverage> findAll();

    Coverage save(Coverage coverage);
}

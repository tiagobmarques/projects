package com.banking.cardinsurance.api.v1.cardinsurance;

import com.banking.cardinsurance.core.cardinsurance.CardInsuranceService;
import com.banking.cardinsurance.core.cardinsurance.Coverage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/card-insurance/coverage")
public class CoverageController {

    @Autowired
    private CardInsuranceService service;

    @GetMapping
    public List<Coverage> findAllCoverages() {
        return service.findAllCoverages();
    }
}
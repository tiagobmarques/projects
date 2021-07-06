package com.banking.cardinsurance.api.v1.cardinsurance;

import com.banking.cardinsurance.core.cardinsurance.CardInsuranceService;
import com.banking.cardinsurance.core.cardinsurance.Coverage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coverage saveCoverage(@RequestBody Coverage coverage) {
        return service.saveCoverage(coverage);
    }

    @GetMapping("/{id}")
    public Coverage findCoverageById(@PathVariable UUID id) {
        return service.findCoverageById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoverageById(@PathVariable UUID id) {
        service.deleteCoverage(id);
    }
}
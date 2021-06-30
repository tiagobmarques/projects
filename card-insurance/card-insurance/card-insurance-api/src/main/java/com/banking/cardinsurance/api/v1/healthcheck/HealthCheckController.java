package com.banking.cardinsurance.api.v1.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/healthcheck")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> serviceIsRunning() {
        return ResponseEntity.status(HttpStatus.OK).body("Service is running!");
    }

}

package com.banking.cardinsurance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.banking.cardinsurance.api",
        "com.banking.cardinsurance.core",
        "com.banking.cardinsurance.infrastructure"})
public class CardInsuranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardInsuranceApplication.class, args);
    }

}

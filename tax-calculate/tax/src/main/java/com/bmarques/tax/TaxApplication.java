package com.bmarques.tax;

import com.bmarques.tax.domain.InvoiceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class TaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxApplication.class, args);
    }

    @Autowired
    private InvoiceService service;

    @Bean
    public Supplier<List<InvoiceEntity>> calculate() {
        return () -> service.calculate();
    }

}

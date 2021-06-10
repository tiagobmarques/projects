package com.bmarques.invoice.api.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

    private UUID id;
    private LocalDate installmentDate;
    private String document;
    private String client;
    private Double value;

}
package com.bmarques.invoice.api.invoice;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponse {

    private UUID id;
    private LocalDate installmentDate;
    private String document;
    private String client;
    private Double value;

}
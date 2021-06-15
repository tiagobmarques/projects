package com.bmarques.invoice.api.invoice;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponse {

    private String id;
    private LocalDate installmentDate;
    private String document;
    private String client;
    private Double value;

}
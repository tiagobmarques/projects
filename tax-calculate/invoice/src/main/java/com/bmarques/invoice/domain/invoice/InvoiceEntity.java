package com.bmarques.invoice.domain.invoice;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "invoice")
public class InvoiceEntity {

    @Id
    @Column(name = "invoice_id")
    private UUID id;
    @Column(name = "installment_date")
    private LocalDate installmentDate;
    private String document;
    private String client;
    private Double value;

}

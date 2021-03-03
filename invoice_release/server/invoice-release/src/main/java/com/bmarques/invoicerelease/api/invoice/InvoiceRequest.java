package com.bmarques.invoicerelease.api.invoice;

import com.bmarques.invoicerelease.api.participant.ParticipantRequest;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

  private Integer id;
  private LocalDate installmentDate;
  private String document;
  private ParticipantRequest participant;
  private Double value;

}

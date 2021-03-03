package com.bmarques.invoicerelease.api.invoice;

import com.bmarques.invoicerelease.api.participant.ParticipantResponse;
import com.bmarques.invoicerelease.domain.participant.ParticipantEntity;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponse {

  private Integer id;
  private LocalDate installmentDate;
  private String document;
  private ParticipantResponse participant;
  private Double value;

}

package com.bmarques.invoicerelease.domain.invoice;

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
public class InvoicePartialDto {

  private Integer id;
  private LocalDate installmentDate;
  private String document;
  private Integer participantId;
  private String participantName;
  private Double value;

}
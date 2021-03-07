package com.bmarques.invoicerelease.api.invoice;

import com.bmarques.invoicerelease.api.participant.ParticipantMapper;
import com.bmarques.invoicerelease.domain.invoice.InvoiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

  @Autowired
  private ParticipantMapper participantMapper;

  public InvoiceResponse toResponse(InvoiceEntity invoiceEntity) {
    return InvoiceResponse.builder()
        .id(invoiceEntity.getId())
        .document(invoiceEntity.getDocument())
        .installmentDate(invoiceEntity.getInstallmentDate())
        .participantId(invoiceEntity.getParticipantId())
        .value(invoiceEntity.getValue())
        .build();
  }

  public InvoiceEntity toEntity(InvoiceRequest invoiceRequest) {
    return InvoiceEntity.builder()
        .id(invoiceRequest.getId())
        .participantId(invoiceRequest.getParticipantId())
        .document(invoiceRequest.getDocument())
        .installmentDate(invoiceRequest.getInstallmentDate())
        .value(invoiceRequest.getValue())
        .build();
  }
}

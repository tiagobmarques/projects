package com.bmarques.invoice.api.invoice;

import com.bmarques.invoice.domain.invoice.InvoiceEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InvoiceMapper {

    public InvoiceResponse toResponse(InvoiceEntity invoiceEntity) {
        return InvoiceResponse.builder()
                .id(invoiceEntity.getId())
                .document(invoiceEntity.getDocument())
                .installmentDate(invoiceEntity.getInstallmentDate())
                .client(invoiceEntity.getClient())
                .value(invoiceEntity.getValue())
                .build();
    }

    public InvoiceEntity toEntity(InvoiceRequest invoiceRequest) {
        return InvoiceEntity.builder()
                .id(invoiceRequest.getId())
                .client(invoiceRequest.getClient())
                .document(invoiceRequest.getDocument())
                .installmentDate(invoiceRequest.getInstallmentDate())
                .value(invoiceRequest.getValue())
                .build();
    }
}
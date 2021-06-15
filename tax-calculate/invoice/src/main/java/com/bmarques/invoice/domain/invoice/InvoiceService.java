package com.bmarques.invoice.domain.invoice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    private final InvoiceRepository invoiceRepository;
    private final QueueMessagingTemplate queueMessagingTemplate;

    public InvoiceService(InvoiceRepository invoiceRepository, QueueMessagingTemplate queueMessagingTemplate) {
        this.invoiceRepository = invoiceRepository;
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public List<InvoiceEntity> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public InvoiceEntity save(InvoiceEntity invoiceEntity) {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(invoiceEntity).build());
        return invoiceRepository.save(invoiceEntity);
    }

    public Optional<InvoiceEntity> getInvoiceById(UUID id) {
        return invoiceRepository.findById(id.toString());
    }
}

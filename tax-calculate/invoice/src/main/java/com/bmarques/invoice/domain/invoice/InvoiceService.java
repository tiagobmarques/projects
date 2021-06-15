package com.bmarques.invoice.domain.invoice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceEntity> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public InvoiceEntity save(InvoiceEntity invoiceEntity) {
        return invoiceRepository.save(invoiceEntity);
    }

    public Optional<InvoiceEntity> getInvoiceById(UUID id) {
        return invoiceRepository.findById(id.toString());
    }
}

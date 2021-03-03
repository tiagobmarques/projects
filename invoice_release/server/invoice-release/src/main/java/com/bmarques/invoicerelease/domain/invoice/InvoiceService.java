package com.bmarques.invoicerelease.domain.invoice;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  public List<InvoiceEntity> getAllInvoices() {
    return invoiceRepository.findAll();
  }

  public InvoiceEntity save(InvoiceEntity invoiceEntity) {
    return invoiceRepository.save(invoiceEntity);
  }

  public Optional<InvoiceEntity> getInvoiceById(Integer id) {
    return invoiceRepository.findById(id);
  }
}

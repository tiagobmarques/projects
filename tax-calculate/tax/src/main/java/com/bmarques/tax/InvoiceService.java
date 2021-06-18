package com.bmarques.tax;

import com.bmarques.tax.domain.InvoiceEntity;
import com.bmarques.tax.domain.TaxEntity;
import com.bmarques.tax.repository.InvoiceRepository;
import com.bmarques.tax.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private TaxRepository taxRepository;

    public List<InvoiceEntity> calculate() {
        Double base = 0D;
        Double tax;

        List<InvoiceEntity> invoiceList = invoiceRepository.findAll();

        for (InvoiceEntity invoice : invoiceList) {
            base += invoice.getValue();
        }

        tax = base * 0.2;

        TaxEntity save = taxRepository
                .save(TaxEntity.builder()
                        .payableValue(tax)
                        .period(LocalDate.now())
                        .build());

        return invoiceList;
    }
}

package com.bmarques.invoice.api.invoice;

import com.bmarques.invoice.domain.invoice.InvoiceEntity;
import com.bmarques.invoice.domain.invoice.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceMapper mapper;

    public InvoiceController(InvoiceService invoiceService, InvoiceMapper mapper) {
        this.invoiceService = invoiceService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<InvoiceEntity> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public InvoiceEntity getInvoiceById(@PathVariable UUID id) {
        return invoiceService.getInvoiceById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Code not found"));
    }

    @PostMapping
    public InvoiceResponse saveInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        var invoiceEntity = mapper.toEntity(invoiceRequest);
        return mapper.toResponse(invoiceService.save(invoiceEntity));
    }
}
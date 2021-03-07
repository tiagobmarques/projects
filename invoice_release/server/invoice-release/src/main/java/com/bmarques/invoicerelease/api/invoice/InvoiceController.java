package com.bmarques.invoicerelease.api.invoice;

import com.bmarques.invoicerelease.domain.invoice.InvoiceEntity;
import com.bmarques.invoicerelease.domain.invoice.InvoicePartialDto;
import com.bmarques.invoicerelease.domain.invoice.InvoiceService;
import com.bmarques.invoicerelease.domain.participant.ParticipantEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/v1/invoice")
public class InvoiceController {

  @Autowired
  private InvoiceService invoiceService;
  @Autowired
  private InvoiceMapper mapper;

  @GetMapping
  public Mono<List<InvoicePartialDto>> getAllInvoices() {
    return Mono.fromCallable(() -> invoiceService.getAllInvoices())
        .subscribeOn(Schedulers.boundedElastic());
  }

  @GetMapping("/{id}")
  public Mono<InvoiceEntity> getInvoiceById(@PathVariable Integer id) {
    return Mono.fromCallable(() -> invoiceService.getInvoiceById(id))
        .map(invoice -> invoice
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                           "Code not found")))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping
  public Mono<InvoiceResponse> saveInvoice(@RequestBody InvoiceRequest invoiceRequest) {
    var invoiceEntity = mapper.toEntity(invoiceRequest);
    return Mono.fromCallable(() -> invoiceService.save(invoiceEntity))
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }
}

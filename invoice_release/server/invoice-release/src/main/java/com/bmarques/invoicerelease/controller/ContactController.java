package com.bmarques.invoicerelease.controller;

import com.bmarques.invoicerelease.model.ContactEntity;
import com.bmarques.invoicerelease.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/v1/contact")
public class ContactController {

  @Autowired
  private ContactService contactService;

  @GetMapping
  public Mono<List<ContactEntity>> getAllContacts() {
    return Mono.fromCallable(() -> contactService.getAllContacts())
        .subscribeOn(Schedulers.boundedElastic());
  }

  @GetMapping("/{id}")
  public Mono<ContactEntity> getContactById(@PathVariable Integer id) {
    return Mono.fromCallable(() -> contactService.getContactById(id))
        .map(invoice -> invoice
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found")))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping
  public Mono<ContactEntity> saveContact(@RequestBody ContactEntity contactEntity) {
    return Mono.fromCallable(() -> contactService.save(contactEntity))
        .subscribeOn(Schedulers.boundedElastic());
  }
}

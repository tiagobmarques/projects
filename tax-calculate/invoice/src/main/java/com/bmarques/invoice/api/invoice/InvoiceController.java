package com.bmarques.invoice.api.invoice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @GetMapping
    public String teste() {
        return "Is Ok!";
    }
}

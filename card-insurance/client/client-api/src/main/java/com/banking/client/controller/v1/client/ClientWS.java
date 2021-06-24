package com.banking.client.controller.v1.client;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class ClientWS {

//    private final InvoiceService invoiceService = new InvoiceService(new InvoiceDao());

    @WebMethod(operationName = "test")
    @WebResult(name = "testResult")
    public String findAll() {
        return "Is OK";
    }

//    @WebMethod(operationName = "findInvoiceById")
//    @WebResult(name = "InvoiceResult")
//    public Invoice findById(@WebParam(name = "invoiceId") Long id) {
//        return invoiceService.findById(id);
//    }
}

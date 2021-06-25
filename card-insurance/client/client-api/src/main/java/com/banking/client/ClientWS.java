package com.banking.client;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class ClientWS {

    @WebMethod(operationName = "HealthCheckMethod")
    @WebResult(name = "HealthCheckResult")
    public String applicationIsOK() {
        return "Is Running";
    }
}

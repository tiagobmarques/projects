package com.banking.client.controller.v1.client;

import javax.jws.WebService;

@WebService
public class ClientWS {

    private HealthCheckController healthCheckController;

    public ClientWS() {
        healthCheckController = new HealthCheckController();
    }

    //    @WebMethod(operationName = "HealthCheckMethod")
//    @WebResult(name = "HealthCheckResult")
//    public String applicationIsOK() {
//        return "Is Running";
//    }
}

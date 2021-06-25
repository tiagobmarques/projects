package com.banking.client.api;

import com.banking.client.core.client.Client;
import com.banking.client.core.client.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@Slf4j
@WebService
public class ClientWS {

    private final ClientService clientService;

    public ClientWS(ClientService clientService) {
        log.info("Entrou no controller primeiro?");
        this.clientService = clientService;
    }

    @WebMethod(operationName = "HealthCheckMethod")
    @WebResult(name = "HealthCheckResult")
    public String applicationIsOK() {
        return "Is Running";
    }

    @WebMethod(operationName = "findAllClients")
    @WebResult(name = "ClientsResult")
    public List<Client> findAll() {

        return clientService.getListClient();
    }
}

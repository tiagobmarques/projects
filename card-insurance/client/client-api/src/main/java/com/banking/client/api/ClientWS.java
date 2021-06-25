package com.banking.client.api;

import com.banking.client.core.client.Client;
import com.banking.client.core.client.ClientService;
import lombok.extern.slf4j.Slf4j;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;
import java.util.UUID;

@Slf4j
@WebService
public class ClientWS {

    private final ClientService clientService;

    public ClientWS(ClientService clientService) {
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

    @WebMethod(operationName = "findClientById")
    @WebResult(name = "ClientResult")
    public Client findById(@WebParam(name = "clientId") UUID id) throws NotFoundException {
        return clientService.getClientById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client %s not found", id)));
    }

    @WebMethod(operationName = "SaveANewClient")
    @WebResult(name = "ClientResult")
    public Client save(@WebParam(name = "item") Client client) {
        return clientService.save(client);
    }

    @WebMethod(operationName = "DeleteAClientById")
    @WebResult(name = "DeletedMessageResult")
    public String deleteById(@WebParam(name = "clientId") UUID id) {
        clientService.deleteById(id);
        return String.format("Client %s deleted!", id);
    }
}

package com.banking.client.api;

import com.banking.client.core.card.Card;
import com.banking.client.core.card.CardService;
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
    private final CardService cardService;

    public ClientWS(ClientService clientService,
                    CardService cardService) {
        this.clientService = clientService;
        this.cardService = cardService;
    }

    @WebMethod(operationName = "HealthCheckMethod")
    @WebResult(name = "HealthCheckResult")
    public String applicationIsOK() {
        return "Is Running";
    }

    @WebMethod(operationName = "findAllClients")
    @WebResult(name = "ClientsResult")
    public List<Client> findAllClients() {
        return clientService.getListClient();
    }

    @WebMethod(operationName = "findClientById")
    @WebResult(name = "ClientResult")
    public Client findByClientId(@WebParam(name = "clientId") UUID id) throws NotFoundException {
        return clientService.getClientById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client %s not found", id)));
    }

    @WebMethod(operationName = "SaveANewClient")
    @WebResult(name = "ClientResult")
    public Client saveClient(@WebParam(name = "item") Client client) {
        return clientService.save(client);
    }

    @WebMethod(operationName = "DeleteAClientById")
    @WebResult(name = "DeletedMessageResult")
    public String deleteByClientId(@WebParam(name = "clientId") UUID id) {
        clientService.deleteById(id);
        return String.format("Client %s deleted!", id);
    }

    @WebMethod(operationName = "findAllCards")
    @WebResult(name = "CardsResult")
    public List<Card> findAllCards() {
        return cardService.getListCard();
    }

    @WebMethod(operationName = "findCardById")
    @WebResult(name = "CardResult")
    public Card findByCardId(@WebParam(name = "cardId") UUID id) throws NotFoundException {
        return cardService.getCardById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Card %s not found", id)));
    }

    @WebMethod(operationName = "SaveANewCard")
    @WebResult(name = "CardResult")
    public Card save(@WebParam(name = "item") Card card) {
        return cardService.save(card);
    }

    @WebMethod(operationName = "DeleteACardById")
    @WebResult(name = "DeletedMessageResult")
    public String deleteById(@WebParam(name = "cardId") UUID id) {
        cardService.deleteById(id);
        return String.format("Card %s deleted!", id);
    }
}

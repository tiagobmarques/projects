package com.banking.client.api;

import com.banking.client.core.card.CardService;
import com.banking.client.core.client.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Slf4j
@Configuration
public class ConfigApplication {

    @Value("${server.url}")
    private String url;

    private final ClientService clientService;
    private final CardService cardService;

    public ConfigApplication(ClientService clientService, CardService cardService) {
        this.clientService = clientService;
        this.cardService = cardService;
    }

    @Bean
    public void createServer() {
        ClientWS clientWS = new ClientWS(clientService, cardService);

        Endpoint.publish(url, clientWS);
        log.info("Client WD is running in the " + url);
    }
}

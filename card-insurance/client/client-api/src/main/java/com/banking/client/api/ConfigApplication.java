package com.banking.client.api;

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

    public ConfigApplication(ClientService clientService) {
        this.clientService = clientService;
    }

    @Bean
    public void createServer() {
        ClientWS clientWS = new ClientWS(clientService);

        Endpoint.publish(url, clientWS);
        log.info("Client WD is running in the " + url);
    }
}

package com.banking.client;

import com.banking.client.ClientWS;
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

    @Bean
    public void createServer() {
        ClientWS clientWS = new ClientWS();

        Endpoint.publish(url, clientWS);
        log.info("Client WD is running in the " + url);
    }
}

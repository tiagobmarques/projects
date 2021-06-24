package com.banking.client.controller.v1.client;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;4
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

//        System.out.println("InvoiceWS rodando: " + URL);
        System.out.println(url);
        Endpoint.publish(url, clientWS);
    }
}

package com.banking.client.infrastructure.client;

import com.banking.client.core.client.ClientRepository;
import com.banking.client.core.client.ClientService;
import com.banking.client.infrastructure.client.postgresql.ClientPostgresqlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ClientServiceFactory {

    private final ClientPostgresqlRepository repository;
    private final ClientMapper mapper;

    @Autowired
    public ClientServiceFactory(ClientPostgresqlRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Bean
    @Autowired
    public ClientService createProductService(ClientRepository repository) {
        log.info("Entrou no bean definition primeiro?");
        return new ClientService(repository);
    }

    @Bean
    public ClientRepository createClientRepository() {
        return new ClientRepositoryBridge(this.repository, this.mapper);
    }

}
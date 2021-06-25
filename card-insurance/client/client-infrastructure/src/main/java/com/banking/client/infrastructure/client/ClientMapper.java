package com.banking.client.infrastructure.client;

import com.banking.client.core.client.Client;
import com.banking.client.infrastructure.client.postgresql.ClientEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientMapper {
    public Client toClass(ClientEntity clientEntity) {
        return Client.builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .email(clientEntity.getEmail())
                .address(clientEntity.getAddress())
                .neighborhood(clientEntity.getNeighborhood())
                .city(clientEntity.getCity())
                .state(clientEntity.getState())
                .country(clientEntity.getCountry())
                .registryDate(clientEntity.getRegistryDate())
                .bankBranch(clientEntity.getBankBranch())
                .bankAccount(clientEntity.getBankAccount())
                .build();
    }
}
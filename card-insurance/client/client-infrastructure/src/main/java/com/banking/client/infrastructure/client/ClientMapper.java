package com.banking.client.infrastructure.client;

import com.banking.client.core.client.Client;
import com.banking.client.infrastructure.card.CardMapper;
import com.banking.client.infrastructure.client.postgresql.ClientEntity;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class ClientMapper {

    private final CardMapper cardMapper;

    public ClientMapper(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

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
                .cards(clientEntity.getCards().stream()
                        .map(cardMapper::toClass)
                        .collect(Collectors.toSet()))
                .build();
    }

    public ClientEntity toEntity(Client client) {
        return ClientEntity.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .address(client.getAddress())
                .neighborhood(client.getNeighborhood())
                .city(client.getCity())
                .state(client.getState())
                .country(client.getCountry())
                .registryDate(client.getRegistryDate())
                .bankBranch(client.getBankBranch())
                .bankAccount(client.getBankAccount())
                .cards(client.getCards().stream()
                        .map(cardMapper::toEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
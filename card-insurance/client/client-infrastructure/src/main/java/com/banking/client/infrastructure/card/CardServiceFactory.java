package com.banking.client.infrastructure.card;

import com.banking.client.core.card.CardRepository;
import com.banking.client.core.card.CardService;
import com.banking.client.infrastructure.card.postgresql.CardPostgresqlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CardServiceFactory {

    private final CardPostgresqlRepository repository;
    private final CardMapper mapper;

    @Autowired
    public CardServiceFactory(CardPostgresqlRepository repository, CardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Bean
    @Autowired
    public CardService createCardService(CardRepository repository) {
        return new CardService(repository);
    }

    @Bean
    public CardRepository createCardRepository() {
        return new CardRepositoryBridge(this.repository, this.mapper);
    }

}
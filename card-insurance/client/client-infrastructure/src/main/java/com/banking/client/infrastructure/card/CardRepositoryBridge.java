package com.banking.client.infrastructure.card;

import com.banking.client.core.card.Card;
import com.banking.client.core.card.CardRepository;
import com.banking.client.infrastructure.card.postgresql.CardEntity;
import com.banking.client.infrastructure.card.postgresql.CardPostgresqlRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class CardRepositoryBridge implements CardRepository {

    private final CardPostgresqlRepository repository;
    private final CardMapper mapper;

    public CardRepositoryBridge(CardPostgresqlRepository repository, CardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Card> findAll() {
        List<CardEntity> cards = repository.findAll();

        return cards.stream()
                .map(mapper::toClass)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Card> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toClass);
    }

    @Override
    public Card save(Card card) {
        CardEntity cardEntity = repository.save(mapper.toEntity(card));
        return mapper.toClass(cardEntity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}

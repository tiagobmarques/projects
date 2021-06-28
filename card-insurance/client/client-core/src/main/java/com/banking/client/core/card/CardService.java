package com.banking.client.core.card;

import com.banking.client.core.client.Client;
import com.banking.client.core.client.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public List<Card> getListCard() {
        return repository.findAll();
    }

    public Optional<Card> getCardById(UUID id){
        return repository.findById(id);
    }

    public Card save(Card card) {
        return repository.save(card);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
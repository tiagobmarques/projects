package com.banking.client.core.card;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardRepository {

    List<Card> findAll();

    Optional<Card> findById(UUID id);

    Card save(Card card);

    void deleteById(UUID id);

}

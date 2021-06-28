package com.banking.client.infrastructure.card;

import com.banking.client.core.card.Card;
import com.banking.client.infrastructure.card.postgresql.CardEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardMapper {
    public Card toClass(CardEntity cardEntity) {
        return Card.builder()
                .id(cardEntity.getId())
                .number(cardEntity.getNumber())
                .nameOnCard(cardEntity.getNameOnCard())
                .expirationDate(cardEntity.getExpirationDate())
                .securityCode(cardEntity.getSecurityCode())
                .type(cardEntity.getType())
                .clientId(cardEntity.getClientId())
                .build();
    }

    public CardEntity toEntity(Card card) {
        return CardEntity.builder()
                .id(card.getId())
                .number(card.getNumber())
                .nameOnCard(card.getNameOnCard())
                .expirationDate(card.getExpirationDate())
                .securityCode(card.getSecurityCode())
                .type(card.getType())
                .clientId(card.getClientId())
                .build();
    }
}
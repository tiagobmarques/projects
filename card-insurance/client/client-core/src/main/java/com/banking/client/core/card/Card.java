package com.banking.client.core.card;

import com.banking.client.core.client.Client;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private UUID id;
    private String number;
    private String nameOnCard;
    private LocalDate expirationDate;
    private Integer securityCode;
    private String type;
    private UUID clientId;
}

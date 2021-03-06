package com.banking.client.core.client;

import com.banking.client.core.card.Card;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private UUID id;
    private String name;
    private String email;
    private String address;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private LocalDate registryDate;
    private String bankBranch;
    private String bankAccount;
    private Set<Card> cards;
}

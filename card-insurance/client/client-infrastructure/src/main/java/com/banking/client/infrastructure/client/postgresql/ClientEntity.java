package com.banking.client.infrastructure.client.postgresql;

import com.banking.client.core.card.Card;
import com.banking.client.core.client.Client;
import com.banking.client.infrastructure.card.postgresql.CardEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "client")
public class ClientEntity {

    @Id
    @Column("client_id")
    private UUID id;

    private String name;

    private String email;

    private String address;

    private String neighborhood;

    private String city;

    private String state;

    private String country;

    @Column("registry_date")
    private LocalDate registryDate;

    @Column("bank_branch")
    private String bankBranch;

    @Column("bank_account")
    private String bankAccount;

    @MappedCollection(idColumn = "client_id")
    private Set<CardEntity> cards;

}

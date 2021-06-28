package com.banking.client.infrastructure.card.postgresql;


import com.banking.client.core.client.Client;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "card")
public class CardEntity {

    @Id
    @Column("card_id")
    private UUID id;

    private String number;

    @Column("name_on_card")
    private String nameOnCard;

    @Column("expiration_date")
    private LocalDate expirationDate;

    @Column("security_code")
    private Integer securityCode;

    private String type;

    @Column("client_id")
    private UUID clientId;

}

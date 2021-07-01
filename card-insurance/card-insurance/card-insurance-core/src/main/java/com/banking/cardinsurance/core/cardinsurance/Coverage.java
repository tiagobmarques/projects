package com.banking.cardinsurance.core.cardinsurance;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coverage {

    private UUID id;
    private String description;
    private BigDecimal value;
}

package com.bmarques.tax.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.bmarques.tax.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tax")
public class TaxEntity {

    private String id;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate period;

    @DynamoDBAttribute
    private Double payableValue;

    @DynamoDBHashKey(attributeName = "taxId")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }
}

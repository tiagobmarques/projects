package com.banking.cardinsurance.infrastructure.cardinsurance.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "coverage")
public class CoverageEntity {

    private String id;

    @DynamoDBAttribute
    private String description;

    @DynamoDBAttribute
    private BigDecimal value;

    @DynamoDBHashKey(attributeName = "coverageId")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

}

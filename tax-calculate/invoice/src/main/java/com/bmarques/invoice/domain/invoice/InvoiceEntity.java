package com.bmarques.invoice.domain.invoice;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.bmarques.invoice.domain.util.LocalDateConverter;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "invoice")
public class InvoiceEntity {

//    @DynamoDBHashKey(attributeName = "invoiceId")
//    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    @DynamoDBTypeConverted( converter = LocalDateConverter.class)
    private LocalDate installmentDate;

    @DynamoDBAttribute
    private String document;

    @DynamoDBAttribute
    private String client;

    @DynamoDBAttribute
    private Double value;

    @DynamoDBHashKey(attributeName = "invoiceId")
    @DynamoDBAutoGeneratedKey
    public String getId() { return id; }
    //public void setId(String id) { this.id = id; }

//    @DynamoDBTypeConverted( converter = LocalDateConverter.class)
//    public LocalDate getInstallmentDate() {
//        return installmentDate;
//    }
}

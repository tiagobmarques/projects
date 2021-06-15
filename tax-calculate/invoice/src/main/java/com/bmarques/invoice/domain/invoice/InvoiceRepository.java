package com.bmarques.invoice.domain.invoice;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public InvoiceRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public InvoiceEntity save(InvoiceEntity invoiceEntity) {
        dynamoDBMapper.save(invoiceEntity);
        return invoiceEntity;
    }

    public InvoiceEntity findById(String invoiceId) {
        return dynamoDBMapper.load(InvoiceEntity.class, invoiceId);
    }

}
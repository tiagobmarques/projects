package com.bmarques.tax.repository;

import com.bmarques.tax.domain.InvoiceEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, String> {

    Optional<InvoiceEntity> findById(String id);

    List<InvoiceEntity> findAll();
}
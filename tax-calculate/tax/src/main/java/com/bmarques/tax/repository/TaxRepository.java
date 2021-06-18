package com.bmarques.tax.repository;

import com.bmarques.tax.domain.TaxEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface TaxRepository extends CrudRepository<TaxEntity, String> {

}
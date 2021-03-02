package com.bmarques.invoicerelease.repository;

import com.bmarques.invoicerelease.model.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Integer> {

}


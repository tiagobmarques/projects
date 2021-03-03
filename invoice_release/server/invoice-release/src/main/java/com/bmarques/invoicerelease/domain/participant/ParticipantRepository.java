package com.bmarques.invoicerelease.domain.participant;

import com.bmarques.invoicerelease.domain.participant.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Integer> {

}


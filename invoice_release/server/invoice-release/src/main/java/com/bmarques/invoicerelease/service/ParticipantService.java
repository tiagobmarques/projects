package com.bmarques.invoicerelease.service;

import com.bmarques.invoicerelease.model.ParticipantEntity;
import com.bmarques.invoicerelease.repository.ParticipantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

  @Autowired
  private ParticipantRepository participantRepository;

  public List<ParticipantEntity> getAllParticipants() {
    return participantRepository.findAll();
  }

  public ParticipantEntity save(ParticipantEntity participantEntity) {
    return participantRepository.save(participantEntity);
  }

  public Optional<ParticipantEntity> getParticipantById(Integer id) {
    return participantRepository.findById(id);
  }
}

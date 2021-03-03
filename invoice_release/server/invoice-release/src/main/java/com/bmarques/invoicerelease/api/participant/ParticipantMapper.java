package com.bmarques.invoicerelease.api.participant;

import com.bmarques.invoicerelease.domain.contact.ContactEntity;
import com.bmarques.invoicerelease.domain.participant.ParticipantEntity;
import com.bmarques.invoicerelease.domain.participant.RegistrationType;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

  public ParticipantResponse toResponse(ParticipantEntity entity) {
    return new ParticipantResponse(entity.getId(), entity.getContact().getName(),
                                   RegistrationType.valueOf(entity.getRegistrationType()),
                                   entity.getRegistrationNumber());
  }

  public ParticipantEntity toEntity(ParticipantRequest request) {
    return ParticipantEntity.builder()
        .id(request.getId())
        .registrationType(String.valueOf(request.getRegistrationType()))
        .registrationNumber(request.getRegistrationNumber())
        .contact(ContactEntity.builder()
                     .name(request.getName())
                     .build())
        .build();
  }
}

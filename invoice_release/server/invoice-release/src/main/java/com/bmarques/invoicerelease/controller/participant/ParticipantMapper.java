package com.bmarques.invoicerelease.controller.participant;

import com.bmarques.invoicerelease.model.ContactEntity;
import com.bmarques.invoicerelease.model.ParticipantEntity;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

  public ParticipantResponse toResponse(ParticipantEntity entity) {
    return ParticipantResponse.builder()
        .id(entity.getId())
        .name(entity.getContact().getName())
        .registrationType(entity.getRegistrationType())
        .registrationNumber(entity.getRegistrationNumber())
        .build();
  }

  public ParticipantEntity toEntity(ParticipantRequest request) {
    return ParticipantEntity.builder()
        .id(request.getId())
        .registrationType(request.getRegistrationType())
        .registrationNumber(request.getRegistrationNumber())
        .contact(ContactEntity.builder()
                     .name(request.getName())
                     .build())
        .build();
  }
}

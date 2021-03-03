package com.bmarques.invoicerelease.api.participant;

import com.bmarques.invoicerelease.domain.participant.RegistrationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantRequest {
  private Integer id;
  private String name;
  private RegistrationType registrationType;
  private String registrationNumber;
}

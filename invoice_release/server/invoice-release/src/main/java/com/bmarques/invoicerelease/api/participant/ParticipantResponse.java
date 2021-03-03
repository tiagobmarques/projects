package com.bmarques.invoicerelease.api.participant;

import com.bmarques.invoicerelease.domain.participant.RegistrationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantResponse {

  private Integer id;
  private String name;
  private RegistrationType registrationType;
  private String registrationNumber;

}

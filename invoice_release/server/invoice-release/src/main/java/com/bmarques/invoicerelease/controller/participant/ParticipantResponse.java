package com.bmarques.invoicerelease.controller.participant;

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
  private String registrationType;
  private String registrationNumber;

}

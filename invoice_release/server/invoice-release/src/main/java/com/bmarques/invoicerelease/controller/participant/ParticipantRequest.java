package com.bmarques.invoicerelease.controller.participant;

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
  private String registrationType;
  private String registrationNumber;
}

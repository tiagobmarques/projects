package com.bmarques.invoicerelease.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Entity(name = "participant")
public class ParticipantEntity {

  @Id
  private Integer id;
  @Column(name = "registration_type")
  private String registrationType;
  @Column(name = "registration_number")
  private String registrationNumber;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "contact_id", referencedColumnName = "id")
  private ContactEntity contact;

}


package com.bmarques.invoicerelease.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name = "contact")
public class ContactEntity {

  @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;
  private String name;
}

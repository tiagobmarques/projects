package com.bmarques.invoicerelease.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity {

  @Id
  private Integer id;
  private String login;
  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "contact_id", referencedColumnName = "id")
  private ContactEntity contact;

}

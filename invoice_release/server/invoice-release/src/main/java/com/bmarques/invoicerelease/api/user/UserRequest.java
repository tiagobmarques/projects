package com.bmarques.invoicerelease.api.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  private Integer id;
  private String name;
  private String login;
  private String password;
}

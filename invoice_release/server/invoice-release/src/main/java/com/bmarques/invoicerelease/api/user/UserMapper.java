package com.bmarques.invoicerelease.api.user;

import com.bmarques.invoicerelease.domain.contact.ContactEntity;
import com.bmarques.invoicerelease.domain.user.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserResponse toResponse(UserEntity user) {
    return UserResponse.builder()
        .id(user.getId())
        .name(user.getContact().getName())
        .login(user.getLogin())
        .password(user.getPassword())
        .build();
  }

  public UserEntity toEntity(UserRequest userRequest) {
    return UserEntity.builder()
        .id(userRequest.getId())
        .login(userRequest.getLogin())
        .password(userRequest.getPassword())
        .contact(ContactEntity.builder()
                     .name(userRequest.getName())
                     .build())
        .build();
  }
}

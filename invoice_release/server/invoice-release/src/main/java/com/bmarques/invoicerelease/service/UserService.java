package com.bmarques.invoicerelease.service;

import com.bmarques.invoicerelease.model.UserEntity;
import com.bmarques.invoicerelease.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  public UserEntity save(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  public Optional<UserEntity> getUserById(Integer id) {
    return userRepository.findById(id);
  }
}

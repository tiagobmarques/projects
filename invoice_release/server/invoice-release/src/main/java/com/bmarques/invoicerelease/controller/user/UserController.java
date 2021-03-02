package com.bmarques.invoicerelease.controller.user;

import com.bmarques.invoicerelease.model.UserEntity;
import com.bmarques.invoicerelease.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/v1/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper mapper;

  @GetMapping
  public Mono<List<UserResponse>> getAllUsers() {
    return Mono.fromCallable(() -> userService.getAllUsers())
        .map(user -> user.stream().map(mapper::toResponse).collect(Collectors.toList()))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @GetMapping("/{id}")
  public Mono<UserEntity> getUserById(@PathVariable Integer id) {
    return Mono.fromCallable(() -> userService.getUserById(id))
        .map(user -> user
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                           "Code not found")))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping
  public Mono<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
    UserEntity userEntity = mapper.toEntity(userRequest);
    return Mono.fromCallable(() -> userService.save(userEntity))
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }
}

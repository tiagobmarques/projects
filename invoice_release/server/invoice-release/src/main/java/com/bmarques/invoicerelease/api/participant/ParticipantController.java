package com.bmarques.invoicerelease.api.participant;

import com.bmarques.invoicerelease.domain.participant.ParticipantEntity;
import com.bmarques.invoicerelease.domain.participant.ParticipantService;
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
@RequestMapping("/v1/participant")
public class ParticipantController {

  @Autowired
  private ParticipantService participantService;

  @Autowired
  private ParticipantMapper mapper;

  @GetMapping
  public Mono<List<ParticipantResponse>> getAllParticipants() {
    return Mono.fromCallable(() -> participantService.getAllParticipants())
        .map(participant -> participant.stream().map(mapper::toResponse)
            .collect(Collectors.toList()))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @GetMapping("/{id}")
  public Mono<ParticipantEntity> getParticipantById(@PathVariable Integer id) {
    return Mono.fromCallable(() -> participantService.getParticipantById(id))
        .map(participant -> participant
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                           "Code not found")))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping
  public Mono<ParticipantResponse> saveParticipant(@RequestBody ParticipantRequest participantRequest) {
    ParticipantEntity participantEntity = mapper.toEntity(participantRequest);
    return Mono.fromCallable(() -> participantService.save(participantEntity))
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }
}

package com.bmarques.invoicerelease.domain.invoice;

import com.bmarques.invoicerelease.domain.participant.ParticipantRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Autowired
  private ParticipantRepository participantRepository;

  public List<InvoicePartialDto> getAllInvoices() {
    return invoiceRepository.findAll()
        .stream()
        .map(invoiceEntity -> InvoicePartialDto.builder()
            .id(invoiceEntity.getId())
            .document(invoiceEntity.getDocument())
            .installmentDate(invoiceEntity.getInstallmentDate())
            .participantId(invoiceEntity.getParticipantId())
            .participantName(participantRepository.findById(invoiceEntity.getParticipantId()).get().getContact().getName())
            .value(invoiceEntity.getValue())
            .id(invoiceEntity.getId())
            .build())
        .collect(Collectors.toList());
  }

  public InvoiceEntity save(InvoiceEntity invoiceEntity) {
    return invoiceRepository.save(invoiceEntity);
  }

  public Optional<InvoiceEntity> getInvoiceById(Integer id) {
    return invoiceRepository.findById(id);
  }
}

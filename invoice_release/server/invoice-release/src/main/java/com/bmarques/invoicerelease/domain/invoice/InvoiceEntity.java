package com.bmarques.invoicerelease.domain.invoice;

import com.bmarques.invoicerelease.domain.participant.ParticipantEntity;
import java.time.LocalDate;
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
@Entity(name = "invoice")
public class InvoiceEntity {

  @Id
  private Integer id;
  @Column(name = "installment_date")
  private LocalDate installmentDate;
  private String document;
  @Column(name = "participant_id")
  private Integer participantId;
  private Double value;

}
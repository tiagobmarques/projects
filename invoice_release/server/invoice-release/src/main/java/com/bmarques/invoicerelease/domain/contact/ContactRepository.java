package com.bmarques.invoicerelease.domain.contact;

import com.bmarques.invoicerelease.domain.contact.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

}

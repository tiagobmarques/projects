package com.bmarques.invoicerelease.service;

import com.bmarques.invoicerelease.model.ContactEntity;
import com.bmarques.invoicerelease.repository.ContactRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

  @Autowired
  private ContactRepository contactRepository;

  public List<ContactEntity> getAllContacts() {
    return contactRepository.findAll();
  }

  public ContactEntity save(ContactEntity contactEntity) {
    return contactRepository.save(contactEntity);
  }

  public Optional<ContactEntity> getContactById(Integer id) {
    return contactRepository.findById(id);
  }
}

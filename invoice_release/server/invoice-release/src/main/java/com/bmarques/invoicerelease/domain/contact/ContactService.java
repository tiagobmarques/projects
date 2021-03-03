package com.bmarques.invoicerelease.domain.contact;

import com.bmarques.invoicerelease.domain.contact.ContactEntity;
import com.bmarques.invoicerelease.domain.contact.ContactRepository;
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

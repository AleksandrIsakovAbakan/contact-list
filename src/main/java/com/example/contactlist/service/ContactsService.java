package com.example.contactlist.service;

import com.example.contactlist.model.Contact;
import com.example.contactlist.repository.ContactsRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactsService {

    private final ContactsRepositoryImpl contactsRepository;

    public List<Contact> getListAllContacts() {
        return contactsRepository.findAll();
    }

    public Contact editContact(int id){
        Contact contact = contactsRepository.findId(id);
        contact.setCreateOrEdit("edit");
        return contact;
    }

    public void deleteContact(int id){
        contactsRepository.deleteId(id);
    }

    public Contact newContact() {
        Contact contact = new Contact();
        contact.setCreateOrEdit("create");
        return contact;
    }

    public void saveContact(Contact contact) {
        if (contact.getCreateOrEdit().equals("create")) {
            Integer counterId = contactsRepository.maxId();
            if (counterId == null) counterId = 0;
            contact.setId(counterId + 1);
            contactsRepository.saveContact(contact);
        } else {
            contactsRepository.updateId(contact);
        }
    }
}

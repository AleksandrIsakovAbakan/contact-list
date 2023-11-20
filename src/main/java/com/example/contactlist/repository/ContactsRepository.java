package com.example.contactlist.repository;

import com.example.contactlist.model.Contact;

import java.util.List;

public interface ContactsRepository {

    List<Contact> findAll();

    Contact findId(int id);

    void updateId(Contact contact);

    void deleteId(int id);

    void saveContact(Contact contact);

    Integer maxId();
}

package com.example.contactlist.repository;


import com.example.contactlist.mappers.ContactRowMapper;
import com.example.contactlist.model.Contact;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class ContactsRepositoryImpl implements ContactsRepository{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Contact> findAll() {
        log.debug("FindAll");
        String sql = "SELECT * FROM contacts ORDER BY id ASC";
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }

    @Override
    public Contact findId(int id) {
        log.debug("FindId");
        String sql = "SELECT * FROM contacts WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new ContactRowMapper(), id);
        } catch (Exception e){
            return null;
        }
     }

    @Override
    public void updateId(Contact contact) {
        log.debug("UpdateId" + contact);
        String sql = "UPDATE contacts SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(),
                contact.getPhone(), contact.getId());
    }

    @Override
    public void deleteId(int id) {
        log.debug("DeleteId" + id);
        String sql = "DELETE FROM contacts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void saveContact(Contact contact) {
        log.debug("InsertId" + contact);
        String sql = "INSERT INTO contacts (id, first_name, last_name, email, phone) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(),
                contact.getPhone());
    }

    @Override
    public Integer maxId() {
        String sql = "SELECT MAX(id) FROM contacts";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}

package com.example.contactlist.mappers;

import com.example.contactlist.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getInt(1));
        contact.setFirstName(rs.getString(2));
        contact.setLastName(rs.getString(3));
        contact.setEmail(rs.getString(4));
        contact.setPhone(rs.getString(5));
        return contact;
    }
}

package com.example.contactlist.model;

import lombok.Data;

@Data
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String createOrEdit;

}

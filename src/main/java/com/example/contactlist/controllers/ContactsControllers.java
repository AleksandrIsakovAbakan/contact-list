package com.example.contactlist.controllers;

import com.example.contactlist.model.Contact;
import com.example.contactlist.service.ContactsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ContactsControllers {

    private final ContactsService contactsService;

    @GetMapping(value = {"/", "/index"})
    public String getListAllContacts(Model model){
        List<Contact> contactList = contactsService.getListAllContacts();
        model.addAttribute("contactsAll", contactList);
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String updateContact(@PathVariable int id, Model model){
        model.addAttribute("contact", contactsService.editContact(id));
        return "edit";
    }

    @GetMapping("/create")
    public String createContact(Model model){
        model.addAttribute("contact", contactsService.newContact());

        return "edit";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute Contact contact){
        contactsService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable int id){
        contactsService.deleteContact(id);
        return "redirect:/";
    }
}

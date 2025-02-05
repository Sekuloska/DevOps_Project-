package com.example.devops.controller;

import com.example.devops.entity.Contact;
import com.example.devops.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ContactController {

    public final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public String index(Model model) {
        List<Contact> allContacts = contactService.getAllContacts();
        model.addAttribute("contacts", allContacts);
        return "index"; // Spring ќе бара "templates/index.html"
    }

    @PostMapping("/add")
    public String addContact(@RequestParam String name, @RequestParam String phone) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhone(phone);
        contactService.addContact(contact);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteContact(@RequestParam String name) {
        contactService.deleteContact(name);
        return "redirect:/";
    }


    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }

}


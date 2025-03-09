package it.davide.contact_book.controller;

import it.davide.contact_book.dto.ContactDto;
import it.davide.contact_book.service.ContactService;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("ciao")
    public String ciao() {
        return "ciao";
    }

    @PostMapping("create")
    public String newContact(@RequestBody ContactDto contactDto) {
        return contactService.create(contactDto);
    }

    @PutMapping("update")
    public String contactUpdate(@RequestBody ContactDto contactDto) {
        return contactService.update(contactDto);
    }

    @DeleteMapping("delete")
    public String contactDelete(@RequestBody ContactDto contactDto) {
        return  contactService.delete(contactDto);
    }

    @GetMapping("get-contact/{id}")
    public ContactDto readContact(@PathParam("id") Long id) {
        return contactService.get(id);
    }

    @GetMapping("full-list")
    public List<ContactDto> fullList() {
        return contactService.list();
    }
}

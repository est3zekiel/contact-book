package it.davide.contact_book.service;

import it.davide.contact_book.dto.ContactDto;
import it.davide.contact_book.model.Contact;
import it.davide.contact_book.repo.ContactRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final ContactRepo contactRepo;

    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public String create(ContactDto contactDto) {
        Contact newContact = new Contact(null, contactDto.getName(), contactDto.getSurname(), contactDto.getPhone());
        contactRepo.save(newContact);
        return "contact created";
    }

    public String update(ContactDto contactDto) {
        Contact editContact = contactRepo.findById(contactDto.getId()).get();
        editContact.setName(contactDto.getName());
        editContact.setSurname(contactDto.getSurname());
        editContact.setPhone(contactDto.getPhone());
        contactRepo.save(editContact);
        return "Contact Edited";
    }

    public String delete(ContactDto contactDto) {
        Long contactToDeleteID = contactDto.getId();
        Contact deleteContact = contactRepo.findById(contactToDeleteID).get();
        contactRepo.delete(deleteContact);
        return "Contact Deleted";
    }

    public ContactDto get(Long id) {
        Contact getContact = contactRepo.findById(id).get();
        ContactDto result = new ContactDto(getContact.getId(), getContact.getName(), getContact.getSurname(), getContact.getPhone());
        return result;
    }

    public List<ContactDto> list () {
        List<ContactDto> result = new ArrayList<>();
        List<Contact> allContact = contactRepo.findAll();
        for (int i = 0; i < allContact.size(); i++) {
            Contact contact = allContact.get(i);
            ContactDto toEnlist = new ContactDto(contact.getId(), contact.getName(), contact.getSurname(), contact.getPhone());
            result.add(toEnlist);
        }
        return result;
    }

}
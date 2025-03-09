package it.davide.contact_book.dto;

import jakarta.persistence.*;

public class ContactDto {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private byte[] photo;
}

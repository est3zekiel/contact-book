package it.davide.contact_book.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactDto {

    private Long id;
    private String name;
    private String surname;
    private String phone;
}

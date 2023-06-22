package com.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.schoolmanagement.dto.ContactMessageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Email(message = "Please provide valid email")
    @Column(nullable = false,unique = true)
    private String email;

    private String subject;
    private String message;
    @JsonFormat(pattern= "yyyy-MM-dd")
    private LocalDate date= LocalDate.now();

    public ContactMessage(ContactMessageDTO contactMessageDTO) {
        this.name = contactMessageDTO.getName();
        this.email = contactMessageDTO.getEmail();
        this.subject = contactMessageDTO.getSubject();
        this.message = contactMessageDTO.getMessage();
        this.date = LocalDate.now();
    }
}

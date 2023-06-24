package com.schoolmanagement.dto;


import com.schoolmanagement.entity.ContactMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageDTO {


    @NotBlank(message = "name can not be null")
    private String name;

    @Email(message = "Please provide valid email")
    @NotBlank(message = "name can not be null")
    private String email;

    private String subject;
    private String message;
    private LocalDate date= LocalDate.now();

    public ContactMessageDTO(ContactMessage contactMessage) {
        this.name = contactMessage.getName();
        this.email = contactMessage.getEmail();
        this.subject = contactMessage.getSubject();
        this.message = contactMessage.getMessage();
        this.date = contactMessage.getDate();
    }
}

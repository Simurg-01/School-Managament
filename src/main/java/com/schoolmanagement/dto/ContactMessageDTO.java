package com.schoolmanagement.dto;

import com.schoolmanagement.entity.ContactMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageDTO {

        @NotNull
        private String name;
        @Email
        @NotNull
        private String email;
        private String subject;
        private String message;
        private LocalDate localDate;

        public ContactMessageDTO (ContactMessage contactMessage) {

            this.name = contactMessage.getName();
            this.email = contactMessage.getEmail();
            this.message = contactMessage.getMessage();
            this.subject = contactMessage.getSubject();
            this.localDate = contactMessage.getLocalDate();
        }
    }



package com.schoolmanagement.controller;

import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contactmessage")
public class ContactMessageController {
    @Autowired
    private ContactMessageService contactMessageService;

    // http://localhost:8080/contactmessage/greet
    @GetMapping("/greet")
    public String greetSpringBoot() {
        return "Message Service Hi";
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody ContactMessage contactMessage) {
        contactMessageService.saveMessage(contactMessage);
        String message = "Customer saved successfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllContactMessage() {
        List<ContactMessage> contactMessageList = contactMessageService.getAllContactmessage();
        return ResponseEntity.ok(contactMessageList);
    }


}

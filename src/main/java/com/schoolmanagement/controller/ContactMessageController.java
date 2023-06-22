package com.schoolmanagement.controller;

import com.schoolmanagement.dto.ContactMessageDTO;
import com.schoolmanagement.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contactmessage") //http://localhost:8080/contactmessage
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;



    //yeni bir kayit
//    @PostMapping()
//    public ResponseEntity<ContactMessageDTO> createContact(@Valid @RequestBody ContactMessage contactMessage){
//        contactMessageService.saveContact(contactMessage);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
    @PostMapping()
    public ResponseEntity<ContactMessageDTO> createContact(@Valid @RequestBody ContactMessageDTO contactMessageDTO){
        contactMessageService.saveContact(contactMessageDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    @GetMapping
//    public ResponseEntity<List<ContactMessage>> getAllContact(){
//        List<ContactMessage> getAllContact= contactMessageService.getAllContacts();
//        return ResponseEntity.ok(getAllContact);
//
//    }
    //tüm kayitlari goster --> Get
    @GetMapping
    public ResponseEntity<List<ContactMessageDTO>> getAllContact(){
        List<ContactMessageDTO> getAllContactDTO= contactMessageService.getAllContacts();
        return ResponseEntity.ok(getAllContactDTO);
    };
}

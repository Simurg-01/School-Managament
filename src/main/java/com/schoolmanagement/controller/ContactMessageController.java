package com.schoolmanagement.controller;

import com.schoolmanagement.dto.ContactMessageDTO;
import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//    }



    //tüm kayitlari goster --> Get
    @GetMapping
    public ResponseEntity<List<ContactMessageDTO>> getAllContact(){
        List<ContactMessageDTO> getAllContactDTO= contactMessageService.getAllContacts();
        return ResponseEntity.ok(getAllContactDTO);
    }


    //email ile arama -pageable
    @GetMapping("/page/{email}")
    public ResponseEntity<Page<ContactMessageDTO>> getContactMessageByEmailByPage
    (@PathVariable("email") String email,
     @RequestParam(value = "page", required = false, defaultValue = "0") int page,
     @RequestParam(value = "size", required = false, defaultValue = "2") int size,
     @RequestParam(value = "sort", required = false) String prop,
     @RequestParam(value="direction", required = false) Sort.Direction direction)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<ContactMessageDTO> contactMessagesByEmail = contactMessageService.getContactMessageByEmailByPages(pageable, email);
        return new ResponseEntity<>(contactMessagesByEmail, HttpStatus.OK);
    }

    //email ile arama -pageable
    @GetMapping("/page")
    public ResponseEntity<Page<ContactMessageDTO>> getContactMessageBySubjectByPage
    (@RequestParam(name="subject") String subject,
     @RequestParam(value = "page", required = false, defaultValue = "0") int page,
     @RequestParam(value = "size", required = false, defaultValue = "2") int size,
     @RequestParam(value = "sort", required = false) String prop,
     @RequestParam(value="direction", required = false) Sort.Direction direction)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<ContactMessageDTO> contactMessagesBySubject = contactMessageService.getContactMessageBySubjectByPages(pageable, subject);
        return new ResponseEntity<>(contactMessagesBySubject, HttpStatus.OK);
    }






}

package com.schoolmanagement.service;

import com.schoolmanagement.dto.ContactMessageDTO;
import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.exception.ConflictException;
import com.schoolmanagement.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactMessageService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;


//    public List<ContactMessage> getAllContacts() {

//    }

public List<ContactMessageDTO> getAllContacts() {
    List<ContactMessage> getAllContact= contactMessageRepository.findAll();
    List<ContactMessageDTO> getAllContactDTO= new ArrayList<>();
    for (ContactMessage contactMessage:getAllContact){
        ContactMessageDTO dto=new ContactMessageDTO(contactMessage);
        getAllContactDTO.add(dto);
    }
    return getAllContactDTO;
}




    public void saveContact(ContactMessageDTO contactMessageDTO) {

        if(contactMessageRepository.existsByEmail(contactMessageDTO.getEmail())){
            throw new ConflictException("Email already exists!");
        }
        ContactMessage contactMessage=new ContactMessage(contactMessageDTO);
        contactMessageRepository.save(contactMessage);
    }
}

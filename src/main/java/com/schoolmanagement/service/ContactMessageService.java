package com.schoolmanagement.service;

import com.schoolmanagement.dto.ContactMessageDTO;
import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.exception.ConflictException;
import com.schoolmanagement.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactMessageService {
    @Autowired
    private static ContactMessageRepository contactMessageRepository;




//        return contactMessageRepository.findAll();
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




    public static Page<ContactMessageDTO> getContactMessageByEmailByPages(Pageable pageable, String email) {
        Page<ContactMessage> contactMessages= contactMessageRepository. findAllByEmail(pageable,email);

        return contactMessages.map(ContactMessageDTO::new);

    }




}


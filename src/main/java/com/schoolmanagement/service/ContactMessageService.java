package com.schoolmanagement.service;

import com.schoolmanagement.entity.ContactMessage;
import com.schoolmanagement.exception.ConflictException;
import com.schoolmanagement.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactMessageService {
    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public void saveMessage(ContactMessage contactMessage) {
        boolean isExist = contactMessageRepository.existsByEmail(contactMessage.getEmail());
        if (isExist) {
            throw new ConflictException("Customer already exists by " + contactMessage.getEmail());
        }
        contactMessageRepository.save(contactMessage);
    }


    public List<ContactMessage> getAllContactmessage() {
        List<ContactMessage> contactMessages =contactMessageRepository.findAll();
        return contactMessages;
    }
}

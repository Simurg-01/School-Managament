package com.schoolmanagement.repository;

import com.schoolmanagement.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ContactMessageRepository extends JpaRepository<ContactMessage,Long> {
    boolean existsByEmail(String email);


}

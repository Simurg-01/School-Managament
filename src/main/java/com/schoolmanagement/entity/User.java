package com.schoolmanagement.entity;

import com.schoolmanagement.entity.enums.Gender;
import com.schoolmanagement.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass // @JoinedTable  @SingleTable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String ssn;

    private String name;

    private String surname;

    private LocalDate birthDay;

    private String birthPlace;

    private String password;

    @Column(unique = true)
    private String phoneNumber;

    private Gender gender;

    private UserRole userRole;
}

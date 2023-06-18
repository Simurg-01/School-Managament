package com.schoolmanagement.entity;

import com.schoolmanagement.entity.enums.Gender;
import com.schoolmanagement.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends User{



    @Email(message = "Please enter valid Email")
    @Column(unique = true)
    private String email;

    private boolean isActive;


}

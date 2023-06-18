package com.schoolmanagement.entity;

import com.schoolmanagement.entity.enums.Gender;
import com.schoolmanagement.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {

    private boolean built_in;

}

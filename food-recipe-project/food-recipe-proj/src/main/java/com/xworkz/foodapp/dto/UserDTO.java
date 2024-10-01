package com.xworkz.foodapp.dto;

import com.xworkz.foodapp.constant.FoodType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
@Entity
public class UserDTO {
    @Id
    @GeneratedValue
    private int userId;

    @NotNull(message = "FIRST NAME NEEDS TO BE THERE")
    @Size(max = 10, min = 3, message = "FIRST NAME IS INVALID")
    private String firstName;

    @NotNull(message = "LAST NAME NEEDS TO BE THERE")
    @Size(max = 15, min = 1, message = "LAST NAME IS INVALID")
    private String lastName;

    @NotNull(message = "MAIL ID NEEDS TO BE THERE")
    private String emailId;

    @NotNull(message = "CONTACT NUMBER NEEDS TO BE THERE")
    @Size(max = 10, min = 10, message = "CONTACT NUMBER IS INVALID")
    private long contactNumber;

    @Size(max = 10, min = 10, message = "ALTERNATIVE NUMBER IS INVALID")
    private long alternativeNumber;

    @NotNull(message = "FOODTYPE NOT SELECTED")
    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @NotNull(message = "ADDRESS NEEDS TO BE THERE")
    @Size(max = 30, min = 5, message = "ADDRESS IS INVALID")
    private String address;

    @NotNull(message = "PASSWORD NEEDS TO BE THERE")
    @Size(max = 10, min = 8, message = "PASSWORD IS INVALID")
    private String password;

    @JoinColumn(name = "auditId")
    @OneToOne(cascade = CascadeType.ALL)
    private AuditDTO auditDTO;
}

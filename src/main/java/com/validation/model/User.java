package com.validation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.lang.annotation.Documented;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ums_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank(message = "User Id is mandatory")
    private Integer UserId;
    @NotBlank(message = "Name is mandatory")
    private String username;
    @NotBlank(message = "DOB is mandatory")
    private String DateOfBirth;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Enter a valid email")
    private String  email;
    @Length(max = 12,message = "length of phone number should be 12 digit ,first two digit is country code and rest phone number")
    @NotBlank(message = "phone number is mandatory")
    private String Phone_Num;
    @NotBlank(message = "Enter date in yyyy-mm-dd format")
//    @JsonFormat(pattern="yyyy-MM-dd")
    private String Date;
    private String Time;
}

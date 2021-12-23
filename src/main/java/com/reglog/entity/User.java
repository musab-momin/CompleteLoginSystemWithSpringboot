package com.reglog.entity;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "space and special symbols not allowed")
    @Size(min = 3, max = 12, message = "name should be between 3 to 12")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$", message = "space and special symbols not allowed")
    @Column(length = 100, nullable = false, unique = false)
    private String firstName;

    @NotBlank(message = "space and special symbols not allowed")
    @Size(min = 3, max = 12, message = "name should be between 3 to 12")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$", message = "space and special symbols not allowed")
    @Column(length = 100, nullable = false, unique = false)
    private String lastName;

    @NotBlank(message = "email is mandatory")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "email is not valid")
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "password is mandatory")
    @Size(min = 8, message = "password should contains 8 characters")
    @Pattern(regexp = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "password pattern is not satisfied")
    @Column(length = 255, nullable = false, unique = false)
    private String password;


    private String role;
    private LocalDate registerDate;
    private String registerTime;

    public User(String firstName, String lastName, String email, String password, String role)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail(){  return this.email;  }




}

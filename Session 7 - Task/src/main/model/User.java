package main.model;

import lombok.*;

import java.time.LocalDate;


@Data
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    private String city;

}

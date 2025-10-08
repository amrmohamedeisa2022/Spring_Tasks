package main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String city;

}

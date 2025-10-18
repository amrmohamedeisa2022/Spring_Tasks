package main.model;

import lombok.*;
import main.specialAnnotation.ConfirmPassword;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfirmPassword
public class Employee {

    private int id;


    @NotEmpty(message = "this field cannot empty or null")
    private String username;

    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$", message = "Password must contain at least one uppercase letter, one special character, and be at least 8 characters long")
    private String password;

    @NotEmpty(message = "this field cannot empty or null")
     private String confirmPassword;


}

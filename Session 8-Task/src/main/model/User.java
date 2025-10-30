package main.model;

import lombok.*;
import main.specialAnnotation.ContactNumberConstraint;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

//    @NotNull(message = "this field is required")
//   @Size(min = 1,message = "this field is required")

    @NotEmpty(message = "this field is required")
      private String username;

    @Min(value = 15,message = "the age must be between 15 and 20")
    @Max(value = 20,message = "the age must be between 15 and 20")
private int age;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Contact number is required")
    @ContactNumberConstraint(message = "Invalid contact number")
private String phone;

    private String password;
 private String country;
private String programmingLanguage;
private List<String> operatingSystems;


}

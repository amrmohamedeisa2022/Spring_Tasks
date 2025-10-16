package main.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

 private String username;
 private String password;
 private String country;
private String programmingLanguage;
private List<String> operatingSystems;
}

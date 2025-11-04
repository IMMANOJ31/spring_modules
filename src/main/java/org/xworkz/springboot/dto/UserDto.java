package org.xworkz.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.xworkz.springboot.enums.Gender;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String password;
}

//public record UserDto(
//        String firstName,
//        String lastName,
//        Gender gender,
//        String email,
//        String password
//) {}

//public record UserDto {
//    private static String firstName;
//    private static String lastName;
//    private static Gender gender;
//    private static String email;
//    private static String password;
//}

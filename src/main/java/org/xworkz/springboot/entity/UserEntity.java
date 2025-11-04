package org.xworkz.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.xworkz.springboot.enums.Gender;
@Entity
@Table(name = "user_info")
@Data @AllArgsConstructor @NoArgsConstructor
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Gender gender;
    private String email;
    private String password;
}

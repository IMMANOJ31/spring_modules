package org.xworkz.springboot.service;

import jakarta.validation.Valid;
import org.xworkz.springboot.dto.UserDto;

public interface UserService {
    boolean saveUser(@Valid UserDto dto);

    UserDto fetchUserById(int id);
}

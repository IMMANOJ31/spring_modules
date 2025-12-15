package org.xworkz.springboot.h2.service;

import jakarta.validation.Valid;
import org.xworkz.springboot.mysql.dto.UserDto;

public interface UserService {
    boolean saveUser(@Valid UserDto dto);

    UserDto fetchUserById(int id);

    boolean removeUser(int id);

    boolean updateUser(int id ,@Valid UserDto dto);
}

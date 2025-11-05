package org.xworkz.springboot.service;

import jakarta.validation.Valid;
import org.xworkz.springboot.dto.UserDto;

import java.util.List;

public interface UsersService {

    boolean saveUsers(@Valid List<UserDto> userDto);
}

package org.xworkz.springboot.mysql.service;

import jakarta.validation.Valid;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.entity.UserEntity;

import java.util.List;

public interface UsersService {

    boolean saveUsers(@Valid List<UserDto> userDto);

    List<UserDto> fetchUsers();

    boolean removeUsers();

    List<UserEntity> updateUsers(@Valid List<UserDto> dto);
}

package org.xworkz.springboot.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.entity.UserEntity;
import org.xworkz.springboot.repository.UsersRepo;
import org.xworkz.springboot.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepo repo;


    @Override
    public boolean saveUsers(List<UserDto> userDto) {
        if (userDto == null || userDto.isEmpty()) return false;
        List<UserEntity> userEntities = userDto.stream().map(
                userDto1 -> {
                    UserEntity userEntity = new UserEntity();
                    BeanUtils.copyProperties(userDto,userEntity);
                    System.out.println(userEntity);
                    return userEntity;
                }).toList();
        List<UserEntity> userEntities1 = repo.saveAll(userEntities);
        System.out.println(userEntities1);
        return true;
    }
}

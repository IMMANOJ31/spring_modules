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
    public boolean saveUsers(List<UserDto> userDtos) {
        if (userDtos == null || userDtos.isEmpty()) {
            return false;
        }
        List<UserEntity> userEntities = userDtos.stream()
                .map(userDto -> {
                    UserEntity userEntity = new UserEntity();
                    BeanUtils.copyProperties(userDto, userEntity);
                    return userEntity;
                }).toList();
        List<UserEntity> savedEntities = repo.saveAll(userEntities);
        System.out.println("Saved to DB: " + savedEntities);
        return !savedEntities.isEmpty();
    }

}

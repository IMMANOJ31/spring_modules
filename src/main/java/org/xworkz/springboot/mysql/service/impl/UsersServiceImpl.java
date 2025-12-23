package org.xworkz.springboot.mysql.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.entity.UserEntity;
import org.xworkz.springboot.mysql.repository.UsersRepo;
import org.xworkz.springboot.mysql.service.UsersService;


import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepo repo;

    public UsersServiceImpl(UsersRepo repo){
        this.repo = repo;
    }

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

    @Override
    public List<UserDto> fetchUsers() {
        List<UserEntity> userEntities = repo.findAll();
        return userEntities.stream().map(userEntity -> {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity,userDto);
            System.err.println(userDto);
            return userDto;
        }).toList();
    }

    @Override
    public boolean removeUsers() {
       repo.deleteAll();
       System.err.println("Users removed!!!!");
       return true;
    }

    @Override
    public List<UserEntity> updateUsers(List<UserDto> dto) {
        List<UserEntity> userEntities = dto.stream().map(userDto -> {
            UserEntity entity = new UserEntity();
            BeanUtils.copyProperties(userDto,entity);
            return entity;
        }).toList();
        return repo.saveAll(userEntities);
    }

}

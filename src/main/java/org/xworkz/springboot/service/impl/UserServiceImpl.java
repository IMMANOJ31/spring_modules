package org.xworkz.springboot.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.entity.UserEntity;
import org.xworkz.springboot.repository.UserRepo;
import org.xworkz.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo repo;

    @Override
    public boolean saveUser(UserDto dto) {
        if (dto == null){
            return false;
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(dto,userEntity);
        UserEntity save = repo.save(userEntity);
        System.out.println("Saved User: " + save);
        return true;
    }

    @Override
    public UserDto fetchUserById(int id) {
        UserEntity userEntity = repo.findById(id).orElse(null);
        if (userEntity != null){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity,userDto);
            return userDto;
        }
        return null;
    }
}

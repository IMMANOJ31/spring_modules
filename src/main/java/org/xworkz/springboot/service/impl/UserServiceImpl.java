package org.xworkz.springboot.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.entity.UserEntity;
import org.xworkz.springboot.repository.UserRepo;
import org.xworkz.springboot.service.UserService;

import java.util.Optional;

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

    @Override
    public boolean removeUser(int id) {
        if (id == 0){
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateUser(int id,UserDto dto) {
        Optional<UserEntity> optionalUser = repo.findById(id);
        if (optionalUser.isEmpty()) {
            return false;
        }

        UserEntity userEntity = optionalUser.get();
        BeanUtils.copyProperties(dto, userEntity, "id");
        repo.save(userEntity);
        return true;
    }

}

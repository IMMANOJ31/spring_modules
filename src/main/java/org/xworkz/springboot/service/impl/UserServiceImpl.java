package org.xworkz.springboot.service.impl;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.entity.UserEntity;
import org.xworkz.springboot.mapper.UserMapper;
import org.xworkz.springboot.repository.UserRepo;
import org.xworkz.springboot.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo repo;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepo repo, UserMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public boolean saveUser(UserDto dto) {
        if (dto == null){
            return false;
        }
        //UserEntity userEntity = UserMapper.createInstance.userDtoToUserEntity(dto);
        UserEntity userEntity = mapper.userDtoToUserEntity(dto);
        UserEntity save = repo.save(userEntity);
        System.out.println("Saved User: " + save);
        return true;
    }

    @Override
    @Cacheable(value = "bootCache", key = "#id")
    public UserDto fetchUserById(int id) {
        UserEntity userEntity = repo.findById(id).orElse(null);
        if (userEntity != null){
//            UserDto userDto = new UserDto();
//            BeanUtils.copyProperties(userEntity,userDto);
            //UserDto userDto = UserMapper.createInstance.userEntityToUserDto(userEntity);
            UserDto userDto = mapper.userEntityToUserDto(userEntity);

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

        UserEntity existing = optionalUser.get();
        //UserEntity userEntity = UserMapper.createInstance.userDtoToUserEntity(dto);
        UserEntity userEntity = mapper.userDtoToUserEntity(dto);
        userEntity.setId(existing.getId());
        repo.save(userEntity);
        return true;
    }

}

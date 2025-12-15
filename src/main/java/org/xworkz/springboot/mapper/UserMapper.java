package org.xworkz.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.xworkz.springboot.mysql.dto.UserDto;
import org.xworkz.springboot.entity.UserEntity;


@Mapper(componentModel = "spring")//impl for this is given by MapStructProcessor-> Processor(interface) given by java to process annotations
public interface UserMapper {

    UserMapper createInstance = Mappers.getMapper(UserMapper.class);

    //@Mapping() used incase have different named field in dto & entity (source,target)
    @Mapping(target = "id", ignore = true)
    UserEntity userDtoToUserEntity(UserDto dto);

    UserDto userEntityToUserDto(UserEntity entity);
}

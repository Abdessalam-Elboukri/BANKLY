package com.microservices.gatewayservice.services.mapper;

import com.microservices.gatewayservice.entities.Users;
import com.microservices.gatewayservice.services.dto.UserDto;
import org.mapstruct.* ;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, Users>{

}

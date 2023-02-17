package com.bankly.userservice.utiles.mapper;


import com.bankly.userservice.services.dto.UserAppDto;
import com.bankly.userservice.entities.UserApp;
import org.mapstruct.* ;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserAppDto,UserApp> {
}

package com.microservices.gatewayservice.services;

import com.microservices.gatewayservice.services.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserDto save(UserDto user);

    UserDto findByCin(String cin);

    List<UserDto> getAll() throws IllegalAccessException;
}

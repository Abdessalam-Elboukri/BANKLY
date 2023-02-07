package com.microservices.gatewayservice.services.impl;


import com.microservices.gatewayservice.entities.Users;
import com.microservices.gatewayservice.repositories.UserRepository;
import com.microservices.gatewayservice.services.UserService;
import com.microservices.gatewayservice.services.dto.UserDto;
import com.microservices.gatewayservice.services.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImp(UserMapper userMapper, UserRepository userRepository){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        userDto.setTest("jnkjvkvkjfvn");
        Users user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findByCin(String cin) {
        return null;
    }
}

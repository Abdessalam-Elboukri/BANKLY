package com.microservices.gatewayservice.services.impl;


import com.microservices.gatewayservice.entities.Users;
import com.microservices.gatewayservice.repositories.UserRepository;
import com.microservices.gatewayservice.services.UserService;
import com.microservices.gatewayservice.services.dto.UserDto;
import com.microservices.gatewayservice.services.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Users user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findByCin(String cin) {
        Users user = userRepository.findByCin(cin);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAll() throws IllegalAccessException {
        List<Users> allUsers= userRepository.findAll();
        if(allUsers==null){
            throw new IllegalAccessException("No User Found");
        }else{
            List<UserDto> allUsersDto = userMapper.toDto(allUsers);
            return allUsersDto;
        }
    }
}

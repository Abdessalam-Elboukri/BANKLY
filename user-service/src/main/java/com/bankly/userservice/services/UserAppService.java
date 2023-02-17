package com.bankly.userservice.services;


import com.bankly.userservice.entities.UserApp;
import com.bankly.userservice.services.dto.ResponseDto;
import com.bankly.userservice.services.dto.UserAppDto;

public interface UserAppService {

    UserAppDto findByEmail(String email) throws IllegalAccessException;

    UserAppDto findByCin(String cin) throws IllegalAccessException;


    UserAppDto save(UserAppDto user) throws IllegalAccessException;

    UserApp validateToken(String token);

    ResponseDto generateToken(UserApp userApp);
}

package com.bankly.userservice.controllers;


import com.bankly.userservice.services.dto.Credentials;
import com.bankly.userservice.entities.UserApp;
import com.bankly.userservice.services.UserAppService;
import com.bankly.userservice.services.dto.ResponseDto;
import com.bankly.userservice.services.dto.UserAppDto;
import com.bankly.userservice.utiles.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class UserController {

    AuthenticationManager authenticationManager;
    private final UserAppService userAppService;
    private final UserMapper userMapper;


    public UserController(AuthenticationManager authenticationManager, UserAppService userAppService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
        this.userMapper=userMapper;
    }


    @PostMapping("/register")
    public UserAppDto register(@RequestBody UserAppDto user) throws IllegalAccessException {
        return userAppService.save(user);
    }


    @GetMapping("/validate-token")
    public UserApp validateToken(@PathParam("token") String token) throws IllegalAccessException {
        return userAppService.validateToken(token);
    }

    @PostMapping("/login")
    public ResponseDto login(@RequestBody Credentials auth) throws IllegalAccessException {
        UserAppDto userAppDto = userAppService.findByEmail(auth.getEmail());
        UserApp userApp= userMapper.toEntity(userAppDto);
        return userAppService.generateToken(userApp);
    }

    @GetMapping("/findby_cin/{cin}")
    public UserAppDto findByCin(@PathVariable String cin) throws IllegalAccessException {
        return userAppService.findByCin(cin);
    }

}

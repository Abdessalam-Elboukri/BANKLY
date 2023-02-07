package com.microservices.gatewayservice.controllers;


import com.microservices.gatewayservice.services.UserService;
import com.microservices.gatewayservice.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserControler {

    @Autowired
    UserService userService;


    @PostMapping("register")
    public UserDto register(@RequestBody UserDto user){
        return userService.save(user);
    }

    @GetMapping("findby_cin")
    public UserDto findByCin(String cin){
        return userService.findByCin(cin);
    }
}

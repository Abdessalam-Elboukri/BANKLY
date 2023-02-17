package com.bankly.userservice.services.impl;

import com.bankly.userservice.feign.WalletServiceFeign;
import com.bankly.userservice.services.UserAppService;
import com.bankly.userservice.services.dto.ResponseDto;
import com.bankly.userservice.services.dto.UserAppDto;
import com.bankly.userservice.entities.UserApp;
import com.bankly.userservice.repositories.UserAppRepository;
import com.bankly.userservice.services.dto.WalletDto;
import com.bankly.userservice.utiles.Jwts.JwtUtils;
import com.bankly.userservice.utiles.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserAppService {

    private final UserAppRepository userAppRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final WalletServiceFeign walletService;


    public UserServiceImpl(UserAppRepository userAppRepository,
                           UserMapper userMapper,
                           PasswordEncoder passwordEncoder,
                           JwtUtils jwtUtils,
                           WalletServiceFeign walletService) {
        this.userAppRepository = userAppRepository;
        this.userMapper=userMapper;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtils=jwtUtils;
        this.walletService=walletService;
    }

    @Override
    public UserAppDto save(UserAppDto userDto) throws IllegalAccessException {
        if(userDto==null){
            throw new
                    IllegalAccessException("User is Null");
        }else if(userDto.getEmail()==null ||
                userDto.getPassword()==null ||
                userDto.getFirstName()==null ||
                userDto.getLastName()==null ||
                userDto.getPhone()==null){
            throw new
                    IllegalAccessException("Please Fill All User Information , Some of The information is missing");
        }
        else {
            UserApp user = userMapper.toEntity(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            WalletDto walletDto= new WalletDto();
            walletDto.setUser_cin(user.getCin());
            walletService.createWallet(walletDto);
            userAppRepository.save(user);
            return userMapper.toDto(user);
        }
    }
    @Override
    public UserAppDto findByEmail(String email) throws IllegalAccessException {
        Optional<UserApp> user = userAppRepository.findByEmail(email);
        if (user.isEmpty()){
            throw new IllegalAccessException("User Not Found");
        }else {
            return userMapper.toDto(user.get());
        }
    }

    @Override
    public UserAppDto findByCin(String cin) throws IllegalAccessException {
        Optional<UserApp> user = userAppRepository.findByCin(cin);
        if (user.isEmpty()){
            throw new IllegalAccessException("User Not Found");
        }else {
            return userMapper.toDto(user.get());
        }
    }

    @Override
    public UserApp validateToken(String token) {
        final String userEmail = jwtUtils.extractUsername(token);
        UserApp userApp = userAppRepository.findByEmail(userEmail).get();
        if (userEmail.equals(userApp.getEmail()) && !jwtUtils.isTokenExpired(token)){
            generateToken(userApp);
            return userApp;
        }else {
            return null;
        }
    }

    @Override
    public ResponseDto generateToken(UserApp userApp) {
            Map<String, Object> claims = new HashMap<>();
            return jwtUtils.createToken(claims,userApp);
        }

}

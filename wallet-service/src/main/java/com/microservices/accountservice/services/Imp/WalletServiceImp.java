package com.microservices.accountservice.services.Imp;


import com.microservices.accountservice.entities.Wallet;
import com.microservices.accountservice.repositories.WalletRepository;
import com.microservices.accountservice.services.Mapper.WalletMapper;
import com.microservices.accountservice.services.WalletService;
import com.microservices.accountservice.services.dto.WalletDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletServiceImp implements WalletService {

    private final WalletMapper walletMapper;
    private final WalletRepository walletRepository;

    public WalletServiceImp(WalletMapper walletMapper, WalletRepository walletRepository){
        this.walletMapper = walletMapper;
        this.walletRepository = walletRepository;
    }
    @Override
    public WalletDto save(WalletDto walletDto) throws IllegalAccessException {
        if(walletDto==null){
            throw new IllegalAccessException("An Error Occurred while the processing !");
        }
        else if(walletDto.getUser_cin()==null){
            throw new IllegalAccessException("please Enter a valid information !");
        }
        else{
            Wallet wallet = walletMapper.toEntity(walletDto);
            wallet.setSold((double) 0);
            wallet.setReference(UUID.randomUUID().toString());
            walletRepository.save(wallet);
            return walletMapper.toDto(wallet);
        }
    }

    @Override
    public WalletDto findByReference(String ref) {
        Wallet wallet = walletRepository.findByReference(ref);
        return walletMapper.toDto(wallet);
    }

    @Override
    public WalletDto updateBalance(WalletDto walletDto) throws IllegalAccessException {
        if(walletDto==null){
            throw new IllegalAccessException("An Error while completing the operation  ");
        }else{
            Wallet wallet=walletMapper.toEntity(walletDto);
            wallet =  walletRepository.save(wallet);
            return walletMapper.toDto(wallet);
        }

    }
}

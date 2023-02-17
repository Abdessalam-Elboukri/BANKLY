package com.microservices.accountservice.controllers;


import com.microservices.accountservice.services.WalletService;
import com.microservices.accountservice.services.dto.WalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/create_wallet")
    public WalletDto createWallet(@RequestBody WalletDto walletDto) throws IllegalAccessException {
        System.out.println(walletDto.getUser_cin());
        return walletService.save(walletDto);
    }

    @GetMapping("/wallet/{ref}")
    public WalletDto getByReference(@PathVariable String ref){
        return walletService.findByReference(ref);
    }

    @PutMapping("/withdraw/{ref}")
    public WalletDto withdraw(@PathVariable String ref, @RequestBody Double amount) throws IllegalAccessException {
        WalletDto walletDto1 = walletService.findByReference(ref);
        if(walletDto1==null){
            throw new IllegalAccessException("wallet not Found ! ");
        }
        if(walletDto1.getSold()<amount)
            throw new IllegalAccessException("Insufficient Balance ! ");
        else{
            walletDto1.setSold(walletDto1.getSold()-amount);
            return walletService.updateBalance(walletDto1);
        }

    }

    @PutMapping("/deposit/{ref}")
    public WalletDto deposit(@PathVariable String ref, @RequestBody Double amount) throws IllegalAccessException {
        WalletDto walletDto1 = walletService.findByReference(ref);
        if(walletDto1==null){
            throw new IllegalAccessException("wallet not Found ! ");
        }else{
            walletDto1.setSold(walletDto1.getSold()+amount);
            return walletService.updateBalance(walletDto1);
        }
    }

}
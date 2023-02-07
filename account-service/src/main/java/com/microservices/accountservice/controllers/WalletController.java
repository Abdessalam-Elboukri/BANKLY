package com.microservices.accountservice.controllers;


import com.microservices.accountservice.services.WalletService;
import com.microservices.accountservice.services.dto.WalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("create_wallet")
    public WalletDto createWallet(@RequestBody WalletDto walletDto) throws IllegalAccessException {
        System.out.println(walletDto.getSold());
        return walletService.save(walletDto);
    }

    @GetMapping("/wallet/{ref}")
    public WalletDto getByReference(@PathVariable String ref){
        return walletService.findByReference(ref);
    }
}
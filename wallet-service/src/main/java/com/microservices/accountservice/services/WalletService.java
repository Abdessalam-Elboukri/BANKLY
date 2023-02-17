package com.microservices.accountservice.services;

import com.microservices.accountservice.services.dto.WalletDto;

public interface WalletService {
    WalletDto save(WalletDto walletDto) throws IllegalAccessException;

    WalletDto findByReference(String ref);

    WalletDto updateBalance(WalletDto walletDto) throws IllegalAccessException;
}


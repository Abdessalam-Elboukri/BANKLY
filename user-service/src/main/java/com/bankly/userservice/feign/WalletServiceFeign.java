package com.bankly.userservice.feign;

import com.bankly.userservice.services.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name ="wallet-service")
public interface WalletServiceFeign {
    @PostMapping("/wallets/create_wallet")
    WalletDto createWallet(@RequestBody WalletDto walletDto);

    }

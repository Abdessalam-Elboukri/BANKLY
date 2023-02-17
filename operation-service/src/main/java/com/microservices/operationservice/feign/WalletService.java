package com.microservices.operationservice.feign;

import com.microservices.operationservice.services.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wallet-service")
public interface WalletService {
    @GetMapping("/wallets/wallet/{wallet_ref}")
    WalletDto getByReference(@PathVariable String wallet_ref);

    @PutMapping("/wallets/withdraw/{ref}")
    WalletDto withdraw(@PathVariable String ref, @RequestBody Double amount);

    @PutMapping("/wallets/deposit/{ref}")
    WalletDto deposit(@PathVariable String ref,@RequestBody Double amount);
}

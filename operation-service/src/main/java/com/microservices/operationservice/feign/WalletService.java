package com.microservices.operationservice.feign;

import com.microservices.operationservice.services.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="wallet-service", url = "http://localhost:8082/wallets/api/v1/wallets")
public interface WalletService {
    @GetMapping("/wallet/{wallet_ref}")
    WalletDto getByReference(@PathVariable String wallet_ref);

    @PutMapping("/withdraw/{ref}")
    WalletDto withdraw(@PathVariable String ref, @RequestBody Double amount);
}

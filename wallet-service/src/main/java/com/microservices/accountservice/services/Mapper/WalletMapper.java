package com.microservices.accountservice.services.Mapper;

import com.microservices.accountservice.entities.Wallet;
import com.microservices.accountservice.services.dto.WalletDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface WalletMapper extends EntityMapper<WalletDto, Wallet> {
}

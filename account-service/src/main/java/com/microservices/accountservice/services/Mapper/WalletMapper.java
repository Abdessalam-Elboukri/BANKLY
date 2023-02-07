package com.microservices.accountservice.services.Mapper;

import com.microservices.accountservice.entities.Wallet;
import com.microservices.accountservice.services.dto.WalletDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper extends EntityMapper<WalletDto, Wallet> {
}

package com.microservices.operationservice.services.mapper;

import com.microservices.operationservice.entities.Transaction;
import com.microservices.operationservice.services.dto.TransactionDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface TransactionMapper extends EntityMapper<TransactionDto, Transaction>{

}

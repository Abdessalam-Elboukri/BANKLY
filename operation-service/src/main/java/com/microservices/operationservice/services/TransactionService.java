package com.microservices.operationservice.services;

import com.microservices.operationservice.services.dto.TransactionDto;

public interface TransactionService {
    TransactionDto save(TransactionDto transactionDto) throws IllegalAccessException;
}

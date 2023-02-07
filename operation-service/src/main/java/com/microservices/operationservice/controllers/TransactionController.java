package com.microservices.operationservice.controllers;

import com.microservices.operationservice.services.TransactionService;
import com.microservices.operationservice.services.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transaction/")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("transacte")
    public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto) throws IllegalAccessException {
        return transactionService.save(transactionDto);
    }
}

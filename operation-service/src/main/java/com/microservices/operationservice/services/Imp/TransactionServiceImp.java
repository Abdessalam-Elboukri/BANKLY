package com.microservices.operationservice.services.Imp;
import com.microservices.operationservice.entities.Transaction;
import com.microservices.operationservice.entities.TransactionType;
import com.microservices.operationservice.repositories.TransactionRepository;
import com.microservices.operationservice.services.TransactionService;
import com.microservices.operationservice.services.dto.TransactionDto;
import com.microservices.operationservice.services.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionMapper transactionMapper;
    @Override
    public TransactionDto save(TransactionDto transactionDto) throws IllegalAccessException {
        if(transactionDto == null){
            throw new IllegalAccessException("Error happened. Try again Later !");
        }
        if( transactionDto.getTransactionType() == null ||
            transactionDto.getAmount()<0 ||
            transactionDto.getUser_cin()== null ||
            transactionDto.getWallet_Ref()== null
        ){
            throw new IllegalAccessException("Error in Transaction info");
        }
        else{
            Transaction transaction = transactionMapper.toEntity(transactionDto);
            transaction.setDate(LocalDateTime.now());
            Double testWallet=  10000.0;
            if(transaction.getTransactionType()== TransactionType.DEPOSIT){
                transaction.setNew_Sold(testWallet + transaction.getAmount());
            }
            else if(transaction.getTransactionType()==TransactionType.WITHDRAW){
                if(testWallet < transaction.getAmount()){
                    throw new IllegalAccessException("Your Amount is Unsifussant");
                }
                else{
                    transaction.setNew_Sold(testWallet - transaction.getAmount());
                }
            }
            transactionRepository.save(transaction);
            return transactionMapper.toDto(transaction);
        }
    }



}

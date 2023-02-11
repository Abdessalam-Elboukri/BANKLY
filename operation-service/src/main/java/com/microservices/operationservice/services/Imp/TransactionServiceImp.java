package com.microservices.operationservice.services.Imp;
import com.microservices.operationservice.entities.Transaction;
import com.microservices.operationservice.entities.TransactionType;
import com.microservices.operationservice.feign.UserService;
import com.microservices.operationservice.feign.WalletService;
import com.microservices.operationservice.repositories.TransactionRepository;
import com.microservices.operationservice.services.TransactionService;
import com.microservices.operationservice.services.dto.TransactionDto;
import com.microservices.operationservice.services.dto.UserDto;
import com.microservices.operationservice.services.dto.WalletDto;
import com.microservices.operationservice.services.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionMapper transactionMapper;

    public final UserService userService;
    public final WalletService walletService;
    public TransactionServiceImp(UserService userService , WalletService walletService) {
        this.userService = userService;
        this.walletService=walletService;
    }


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
                WalletDto walletDto = walletService.getByReference(transactionDto.getWallet_Ref());
                UserDto userDto = userService.findByCin(transactionDto.getUser_cin());

            if(walletDto == null || userDto==null ){
                throw new IllegalAccessException("error in your Information");
            }else {
                Transaction transaction = transactionMapper.toEntity(transactionDto);
                transaction.setDate(LocalDateTime.now());
                Double walletBalance = walletDto.getSold() ;
                if (transaction.getTransactionType() == TransactionType.DEPOSIT) {
                    transaction.setNew_Sold(walletBalance + transaction.getAmount());
                }else if (transaction.getTransactionType() == TransactionType.WITHDRAW) {
                    if (walletBalance < transaction.getAmount()) {
                        throw new IllegalAccessException("Your Amount is Insufficient ! Your balance : " + walletBalance);
                    }else {
                        transaction.setNew_Sold(walletBalance - transaction.getAmount());
                        walletService.withdraw(transaction.getWallet_Ref(),transaction.getAmount());
                    }
                }

                transaction = transactionRepository.save(transaction);
                return transactionMapper.toDto(transaction);
            }
        }
    }





}

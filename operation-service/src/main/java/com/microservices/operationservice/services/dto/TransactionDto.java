package com.microservices.operationservice.services.dto;

import com.microservices.operationservice.entities.TransactionType;

import java.time.LocalDateTime;


public class TransactionDto {
    private TransactionType transactionType;
    private String user_cin;
    private String wallet_Ref;
    private LocalDateTime date;
    private Double amount;
    private Double new_Sold;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getUser_cin() {
        return user_cin;
    }

    public void setUser_cin(String user_cin) {
        this.user_cin = user_cin;
    }

    public String getWallet_Ref() {
        return wallet_Ref;
    }

    public void setWallet_Ref(String wallet_Ref) {
        this.wallet_Ref = wallet_Ref;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getNew_Sold() {
        return new_Sold;
    }

    public void setNew_Sold(Double new_Sold) {
        this.new_Sold = new_Sold;
    }

    public TransactionDto() {
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "transactionType=" + transactionType +
                ", user_cin='" + user_cin + '\'' +
                ", wallet_Ref='" + wallet_Ref + '\'' +
                '}';
    }
}

package com.microservices.operationservice.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("transaction")
@Data
public class Transaction {
    private String id;
    private LocalDateTime date;
    private TransactionType transactionType;
    private Double amount;
    private Double new_Sold;
    private String user_cin;
    private String wallet_Ref;
}

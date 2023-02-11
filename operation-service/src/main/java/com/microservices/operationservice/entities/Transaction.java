package com.microservices.operationservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document("transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    private String id;
    private LocalDateTime date;
    private TransactionType transactionType;
    private Double amount;
    private Double new_Sold;
    private String user_cin;
    private String wallet_Ref;
}

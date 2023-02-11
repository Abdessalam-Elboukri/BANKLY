package com.microservices.operationservice.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {
    private String reference;
    private Double sold;
    private String user_cin;
}

package com.bankly.userservice.services.dto;

import java.io.Serializable;

public class WalletDto implements Serializable {
    private String user_cin;


    public String getUser_cin() {
        return user_cin;
    }

    public void setUser_cin(String user_cin) {
        this.user_cin = user_cin;
    }

    public WalletDto(String user_cin) {
        this.user_cin = user_cin;
    }

    public WalletDto() {
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "cinClient='" + user_cin + '\'' +
                '}';
    }
}

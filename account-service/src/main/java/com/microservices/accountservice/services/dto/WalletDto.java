package com.microservices.accountservice.services.dto;

public class WalletDto {
    private String reference;
    private Double sold;
    private String user_cin;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

    public String getUser_cin() {
        return user_cin;
    }

    public void setUser_cin(String user_cin) {
        this.user_cin = user_cin;
    }

    public WalletDto(String reference, Double sold, String user_cin) {
        this.reference = reference;
        this.sold = sold;
        this.user_cin = user_cin;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "reference='" + reference + '\'' +
                ", sold=" + sold +
                ", user_cin='" + user_cin + '\'' +
                '}';
    }
}

package com.microservices.gatewayservice.services.dto;

public class UserDto {
    private static final long serialVersionUID = 1L;
    private String firstname ;
    private String lastname;
    private String cin;
    private String email;
    private String password;
    private String phone;

    private String test;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserDto(String firstname, String lastname, String cin, String email, String password, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cin = cin;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public  UserDto(){}


    public String gettest() {
        return test;
    }
    public void setTest(String test){
        this.test=test;
    }
}

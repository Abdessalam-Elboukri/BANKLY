package com.microservices.gatewayservice.entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstname ;
    private String lastname;
    @Column(unique = true, nullable = false)
    private String cin;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(unique = true, nullable = false)
    private String phone;

    public Users(Long id, String firstname, String lastname, String cin, String email, String password, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cin = cin;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Users() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return id != null && Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.example.demo.bank;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String owner;

    protected Account() {}
    public Account(String owner) { this.owner = owner; }
    public Long getId() { return id; }
    public String getOwner() { return owner; }
}

package com.example.demo.bank;

import jakarta.persistence.*;

@Entity
public class AuditLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String message;

    protected AuditLog() {}
    public AuditLog(String message) { this.message = message; }
    public String getMessage() { return message; }
}

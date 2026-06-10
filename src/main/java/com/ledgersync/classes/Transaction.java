package com.ledgersync.classes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name = "transactions")
public class Transaction {
    
    public enum Status {
        APPROVED,
        FLAGGED,
        PENDING,
        COMPLETED,
        FAILED
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //to support auto id key generation
    private Long id;

    private String merchant;
    private Double amount;
    private Status status;
    private LocalDateTime timestamp;

    protected Transaction() {} //added to avoid JPA error: No default constructor for entity

    public Transaction(Long id, String merchant, Double amount, Status status, LocalDateTime timestamp) {
        this.id = id;
        this.merchant = merchant;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", merchant='" + merchant + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}

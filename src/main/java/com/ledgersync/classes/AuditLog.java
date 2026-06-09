package com.ledgersync.classes;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "audit_logs")
public class AuditLog {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //to support auto id key generation
    private Long id;
    private String actionPerformed; //eg TRANSACTION_APPROVED or TRANSACTION_REJECTED
    private LocalDateTime timestamp;

    protected AuditLog() {} //added to avoid JPA error: No default constructor for entity

    public AuditLog(Long id, String actionPerformed, LocalDateTime timestamp) {
        this.id = id;
        this.actionPerformed = actionPerformed;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(String actionPerformed) {
        this.actionPerformed = actionPerformed;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", actionPerformed='" + actionPerformed + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

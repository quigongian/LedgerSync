package com.ledgersync.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledgersync.classes.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    //custom query methods can be added here if needed, e.g. findByActionType(String actionType);
}

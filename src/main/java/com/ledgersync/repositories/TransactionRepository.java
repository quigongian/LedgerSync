package com.ledgersync.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledgersync.classes.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //custom query methods can be added here if needed, e.g. findByMerchant(String merchant);
}

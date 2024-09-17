package com.zk.budgetmate.repository;

import com.zk.budgetmate.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

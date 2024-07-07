package com.zk.budgetmate.repository;

import com.zk.budgetmate.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}

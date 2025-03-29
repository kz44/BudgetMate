package com.zk.budgetmate.repository;

import com.zk.budgetmate.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


  Optional<Invoice> findByName(final String name);

  boolean existsByName(final String name);
}

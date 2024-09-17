package com.zk.budgetmate.repository;

import com.zk.budgetmate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


  @Query("SELECT u FROM User u JOIN u.invoices i WHERE i.name = :invoiceName")
  User findUserByInvoiceName(@Param("invoiceName") String invoiceName);

  Optional<User> findByUsername(String username);
}

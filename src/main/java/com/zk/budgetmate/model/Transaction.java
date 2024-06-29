package com.zk.budgetmate.model;

import com.zk.budgetmate.enums.PaymentMethodType;
import com.zk.budgetmate.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@Table(name = "transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double amount;

  private PaymentMethodType paymentMethodType;

  private TransactionType transactionType;

  //private Category category;

  private boolean scheduledPayment = false;

  private LocalDateTime transactionDate;
}

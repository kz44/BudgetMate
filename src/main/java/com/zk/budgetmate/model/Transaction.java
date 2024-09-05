package com.zk.budgetmate.model;

import com.zk.budgetmate.enums.PaymentMethodType;
import com.zk.budgetmate.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double amount;

  private boolean scheduledPayment = false;

  private LocalDateTime transactionDate;

  @Enumerated(EnumType.STRING)
  private PaymentMethodType paymentMethodType;

  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  @OneToMany(mappedBy = "transaction")
  private List<Category> categories;

  @ManyToOne
  private Invoice invoice;
}

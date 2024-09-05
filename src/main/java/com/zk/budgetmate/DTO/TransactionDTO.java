package com.zk.budgetmate.DTO;

import com.zk.budgetmate.enums.PaymentMethodType;
import com.zk.budgetmate.enums.TransactionType;
import com.zk.budgetmate.model.Category;
import com.zk.budgetmate.model.Invoice;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {

  private Double amount;

  private boolean scheduledPayment = false;

  private LocalDateTime transactionDate;

  @Enumerated(EnumType.STRING)
  private PaymentMethodType paymentMethodType;

  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  private List<Category> categories;

  private Invoice invoice;
}

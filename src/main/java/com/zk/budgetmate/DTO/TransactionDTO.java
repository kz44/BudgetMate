package com.zk.budgetmate.DTO;

import com.zk.budgetmate.enums.PaymentMethodType;
import com.zk.budgetmate.enums.TransactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {

  private Long id;

  private BigDecimal amount;

  private boolean scheduledPayment = false;

  private LocalDateTime transactionDate;

  @Enumerated(EnumType.STRING)
  private PaymentMethodType paymentMethodType;

  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  @NotBlank
  private String invoiceName;
}

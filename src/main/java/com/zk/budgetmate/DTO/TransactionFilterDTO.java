package com.zk.budgetmate.DTO;

import com.zk.budgetmate.enums.PaymentMethodType;
import com.zk.budgetmate.enums.TransactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class TransactionFilterDTO {

  private LocalDateTime minDate;

  private LocalDateTime maxDate;

  private BigDecimal minAmount;

  private BigDecimal maxAmount;

  @Enumerated(EnumType.STRING)
  private PaymentMethodType paymentMethodType;

  private Boolean scheduledPayment;

  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;
}

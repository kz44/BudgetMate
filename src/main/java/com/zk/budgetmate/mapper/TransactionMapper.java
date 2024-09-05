package com.zk.budgetmate.mapper;

import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionMapper {

  /**
   * Converts a Transaction entity to a TransactionDTO.
   *
   * @param entity the Transaction entity to be converted.
   * @return TransactionDTO containing information based on Transaction entity.
   */
  public TransactionDTO toDTO(Transaction entity) {

    return TransactionDTO.builder()
        .amount(entity.getAmount())
        .scheduledPayment(entity.isScheduledPayment())
        .transactionDate(entity.getTransactionDate())
        .paymentMethodType(entity.getPaymentMethodType())
        .transactionType(entity.getTransactionType())
        .categories(entity.getCategories())
        .invoice(entity.getInvoice())
        .build();
  }


  /**
   * Converts a TransactionDTO to a Transaction entity.
   *
   * @param dto the TransactionDTO to be converted.
   * @return Transaction entity containing information based on TransactionDTO.
   */

  public Transaction toEntity(TransactionDTO dto) {
    return Transaction.builder()
        .amount(dto.getAmount())
        .scheduledPayment(dto.isScheduledPayment())
        .transactionDate(dto.getTransactionDate())
        .paymentMethodType(dto.getPaymentMethodType())
        .transactionType(dto.getTransactionType())
        .categories(dto.getCategories())
        .invoice(dto.getInvoice())
        .build();
  }
}

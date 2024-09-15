package com.zk.budgetmate.mapper;

import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.model.Invoice;
import com.zk.budgetmate.model.Transaction;
import com.zk.budgetmate.repository.InvoiceRepository;
import com.zk.budgetmate.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionMapper {

  private final InvoiceService invoiceService;

  /**
   * Converts a Transaction entity to a TransactionDTO.
   *
   * @param entity the Transaction entity to be converted.
   * @return TransactionDTO containing information based on Transaction entity.
   */
  public TransactionDTO toDTO(Transaction entity) {

    return TransactionDTO.builder()
        .id(entity.getId())
        .amount(entity.getAmount())
        .scheduledPayment(entity.isScheduledPayment())
        .transactionDate(entity.getTransactionDate())
        .paymentMethodType(entity.getPaymentMethodType())
        .transactionType(entity.getTransactionType())
        .invoiceName(entity.getInvoice() != null ? entity.getInvoice().getName() : null)
        .build();
  }


  /**
   * Converts a TransactionDTO to a Transaction entity.
   *
   * @param dto the TransactionDTO to be converted.
   * @return Transaction entity containing information based on TransactionDTO.
   */

  public Transaction toEntity(TransactionDTO dto) {

    Invoice invoice = invoiceService.findByName(dto.getInvoiceName());

    return Transaction.builder()
        .id(dto.getId())
        .amount(dto.getAmount())
        .scheduledPayment(dto.isScheduledPayment())
        .transactionDate(dto.getTransactionDate())
        .paymentMethodType(dto.getPaymentMethodType())
        .transactionType(dto.getTransactionType())
        .invoice(invoice)
        .build();
  }
}

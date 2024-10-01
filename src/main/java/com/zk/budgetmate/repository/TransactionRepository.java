package com.zk.budgetmate.repository;

import com.zk.budgetmate.enums.PaymentMethodType;
import com.zk.budgetmate.enums.TransactionType;
import com.zk.budgetmate.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

  /**
   * Retrieves a list of transactions filtered by the given criteria.
   * <p>
   * This method allows filtering transactions by a range of criteria such as:
   * - minimum and maximum transaction dates
   * - minimum and maximum transaction amounts
   * - payment method type
   * - whether the transaction is a scheduled payment
   * - transaction type (e.g., income or expense)
   * If any parameter is null, the filter for that field will be ignored.
   * </p>
   *
   * @param minDate           the minimum transaction date (inclusive), or null to ignore.
   * @param maxDate           the maximum transaction date (inclusive), or null to ignore.
   * @param minAmount         the minimum transaction amount (inclusive), or null to ignore.
   * @param maxAmount         the maximum transaction amount (inclusive), or null to ignore.
   * @param paymentMethodType the type of payment method (e.g., "CREDIT_CARD", "CASH"), or null to ignore.
   * @param scheduledPayment  whether the transaction is a scheduled payment, or null to ignore.
   * @param transactionType   the type of transaction (e.g., "INCOME", "EXPENSE"), or null to ignore.
   * @return a list of transactions that match the given filtering criteria.
   */

  @Query("SELECT t FROM Transaction t " +
      "WHERE (:minDate IS NULL OR t.transactionDate >= :minDate) " +
      "AND (:maxDate IS NULL OR t.transactionDate <= :maxDate) " +
      "AND (:minAmount IS NULL OR t.amount >= :minAmount) " +
      "AND (:maxAmount IS NULL OR t.amount <= :maxAmount) " +
      "AND (:paymentMethodType IS NULL OR t.paymentMethodType = :paymentMethodType) " +
      "AND (:scheduledPayment IS NULL OR t.scheduledPayment = :scheduledPayment) " +
      "AND (:transactionType IS NULL OR t.transactionType = :transactionType)")
  List<Transaction> findFilteredTransactions(
      @Param("minDate") LocalDateTime minDate,
      @Param("maxDate") LocalDateTime maxDate,
      @Param("minAmount") BigDecimal minAmount,
      @Param("maxAmount") BigDecimal maxAmount,
      @Param("paymentMethodType") PaymentMethodType paymentMethodType,
      @Param("scheduledPayment") Boolean scheduledPayment,
      @Param("transactionType") TransactionType transactionType
  );
}

package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.TransactionDTO;

import javax.management.BadAttributeValueExpException;
import java.util.List;

public interface TransactionService {
  List<TransactionDTO> getAllTransactions();

  TransactionDTO getTransactionById(Long id);

  TransactionDTO updateTransactionById(TransactionDTO dto);

  TransactionDTO saveNewTransaction(TransactionDTO dto) throws BadAttributeValueExpException;

  void deleteTransactionById(Long id);
}

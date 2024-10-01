package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.DTO.TransactionFilterDTO;

import javax.management.BadAttributeValueExpException;
import java.util.List;

public interface TransactionService {
  List<TransactionDTO> getAllTransactions();

  TransactionDTO getTransactionById(Long id);

  TransactionDTO updateTransactionById(TransactionDTO dto);

  TransactionDTO saveNewTransaction(TransactionDTO dto);

  void deleteTransactionById(Long id);

  List<TransactionDTO> filterTransaction(TransactionFilterDTO dto);
}

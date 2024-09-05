package com.zk.budgetmate.service;

import com.zk.budgetmate.mapper.TransactionMapper;
import com.zk.budgetmate.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService{

  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;
}

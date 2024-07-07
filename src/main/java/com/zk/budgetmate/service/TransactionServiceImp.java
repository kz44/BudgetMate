package com.zk.budgetmate.service;

import com.zk.budgetmate.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp {

  private final TransactionRepository transactionRepository;
}

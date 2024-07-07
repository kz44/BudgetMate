package com.zk.budgetmate.service;

import com.zk.budgetmate.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImp {

  private final InvoiceRepository invoiceRepository;
}

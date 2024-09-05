package com.zk.budgetmate.service;

import com.zk.budgetmate.mapper.InvoiceMapper;
import com.zk.budgetmate.model.Invoice;
import com.zk.budgetmate.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImp implements InvoiceService {

  private final InvoiceRepository invoiceRepository;
  private final InvoiceMapper invoiceMapper;

}

package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.InvoiceDTO;
import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.model.Invoice;

import java.util.List;

public interface InvoiceService {

  Invoice findByName(String name);

  List<InvoiceDTO> getAllInvoices();

  InvoiceDTO getInvoiceById(Long id);

  InvoiceDTO getInvoiceByName(String name);

  InvoiceDTO saveNewInvoice(InvoiceDTO dto);

  InvoiceDTO updateInvoiceById(InvoiceDTO dto);

  void deleteInvoiceById(Long id);
}

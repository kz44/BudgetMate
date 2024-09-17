package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.InvoiceDTO;
import com.zk.budgetmate.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

  Invoice findByName(String name);

  List<InvoiceDTO> getAllInvoices();

  Optional<InvoiceDTO> getInvoiceById(Long id);

  InvoiceDTO saveNewInvoice(InvoiceDTO dto);

  void deleteInvoiceById(Long id);
}

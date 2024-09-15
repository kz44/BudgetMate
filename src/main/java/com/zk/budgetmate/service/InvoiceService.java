package com.zk.budgetmate.service;

import com.zk.budgetmate.model.Invoice;

public interface InvoiceService {

  Invoice findByName(String name);
}

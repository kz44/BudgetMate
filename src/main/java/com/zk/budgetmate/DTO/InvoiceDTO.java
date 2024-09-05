package com.zk.budgetmate.DTO;

import com.zk.budgetmate.model.Transaction;
import com.zk.budgetmate.model.User;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class InvoiceDTO {

  @NotBlank
  private String name;

  private Long balance;

  private User user;

  private List<Transaction> transactions;
}

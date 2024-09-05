package com.zk.budgetmate.DTO;

import com.zk.budgetmate.model.Transaction;
import com.zk.budgetmate.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDTO {

  @NotBlank
  private String name;

  private Long balance;

  private User user;

  private List<Transaction> transactions;
}

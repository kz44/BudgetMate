package com.zk.budgetmate.DTO;

import com.zk.budgetmate.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

  private String name;

  private String description;

  private Transaction transaction;
}

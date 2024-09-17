package com.zk.budgetmate.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDTO {

  private Long id;

  @NotBlank
  private String name;

  private BigDecimal balance;

  @NotBlank
  private String owner;
}

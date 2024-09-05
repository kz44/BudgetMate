package com.zk.budgetmate.DTO;

import com.zk.budgetmate.model.Invoice;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class UserDTO {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String email;

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  private LocalDateTime createdAt;

  private List<Invoice> invoices;
}

package com.zk.budgetmate.DTO;

import com.zk.budgetmate.model.Invoice;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

  private Long id;

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

package com.zk.budgetmate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  private BigDecimal balance;

  @ManyToOne
  private User user;

  @OneToMany (mappedBy = "invoice", cascade = CascadeType.ALL)
  private List<Transaction> transactions;
}

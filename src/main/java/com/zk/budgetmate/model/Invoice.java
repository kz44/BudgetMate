package com.zk.budgetmate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "invoices")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  private Long balance;

  @ManyToOne
  private User user;

  @OneToMany (mappedBy = "invoice")
  private List<Transaction> transactions;
}

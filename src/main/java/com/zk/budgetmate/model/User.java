package com.zk.budgetmate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @OneToMany (mappedBy = "user")
  private List<Invoice> invoices;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now(); //automatically create the date when it was created
  }
}

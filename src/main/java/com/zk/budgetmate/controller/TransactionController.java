package com.zk.budgetmate.controller;

import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

  private final TransactionService transactionService;

  @GetMapping
  public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
    return ResponseEntity.ok(transactionService.getAllTransactions());
  }

  @GetMapping("/{id}")
  public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
    return ResponseEntity.ok(transactionService.getTransactionById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TransactionDTO> updateTransactionById(@PathVariable Long id,
                                                              @Valid @RequestBody TransactionDTO dto) {
    dto.setId(id);
    return ResponseEntity.ok(transactionService.updateTransactionById(dto));
  }

  @PostMapping
  public ResponseEntity<TransactionDTO> saveNewCategory(@RequestBody TransactionDTO dto) throws BadAttributeValueExpException {
    return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.saveNewTransaction(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteTransactionById(@PathVariable Long id) {
    transactionService.deleteTransactionById(id);
    return ResponseEntity.noContent().build();
  }
}

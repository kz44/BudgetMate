package com.zk.budgetmate.controller;

import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

  private final TransactionService transactionService;

  /**
   * This endpoint retrieve all transactions.
   *
   * @return a list of all transactions.
   */
  @GetMapping
  public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
    return ResponseEntity.ok(transactionService.getAllTransactions());
  }

  /**
   * This endpoint retrieve a specific transaction by ID.
   *
   * @param id The ID of the transaction to retrieve.
   * @return The transaction with the specified ID.
   */
  @GetMapping("/{id}")
  public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
    return ResponseEntity.ok(transactionService.getTransactionById(id));
  }

  /**
   * This endpoint update a transaction with the given ID.
   *
   * @param id  The ID of the transaction to update.
   * @param dto The new transaction data.
   * @return The updated transaction.
   */
  @PutMapping("/{id}")
  public ResponseEntity<TransactionDTO> updateTransactionById(@PathVariable Long id,
                                                              @Valid @RequestBody TransactionDTO dto) {
    dto.setId(id);
    return ResponseEntity.ok(transactionService.updateTransactionById(dto));
  }

  /**
   * This endpoint create a new transaction.
   *
   * @param dto The transaction data to create.
   * @return The created transaction.
   */
  @PostMapping
  public ResponseEntity<TransactionDTO> saveNewTransaction(@RequestBody TransactionDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.saveNewTransaction(dto));
  }

  /**
   * This endpoint delete a transaction by ID.
   *
   * @param id The ID of the transaction to delete.
   * @return No content, indicating the transaction was successfully deleted.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteTransactionById(@PathVariable Long id) {
    transactionService.deleteTransactionById(id);
    return ResponseEntity.noContent().build();
  }
}

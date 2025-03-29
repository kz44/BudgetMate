package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.DTO.TransactionFilterDTO;
import com.zk.budgetmate.exception.DuplicateResourceException;
import com.zk.budgetmate.exception.ResourceNotFoundException;
import com.zk.budgetmate.mapper.TransactionMapper;
import com.zk.budgetmate.model.Invoice;
import com.zk.budgetmate.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService {

  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;
  private final InvoiceService invoiceService;

  /**
   * Retrieve all transactions.
   *
   * @return A list of all transactions.
   */
  @Override
  public List<TransactionDTO> getAllTransactions() {
    return transactionRepository.findAll()
        .stream()
        .map(transactionMapper::toDTO)
        .toList();
  }

  /**
   * Retrieve a transaction by ID.
   *
   * @param id The ID of the transaction to retrieve.
   * @return The transaction with the specified ID.
   * @throws ResourceNotFoundException If the transaction with the given ID is not found.
   */
  @Override
  public TransactionDTO getTransactionById(Long id) {
    return transactionRepository.findById(id)
        .map(transactionMapper::toDTO)
        .orElseThrow(() -> new ResourceNotFoundException("Transaction was not found with the given id: " + id));
  }

  /**
   * Update an existing transaction.
   *
   * @param dto The updated transaction data.
   * @return The updated transaction.
   * @throws ResourceNotFoundException If the transaction with the given ID is not found.
   */
  @Override
  public TransactionDTO updateTransactionById(TransactionDTO dto) {
    getTransactionById(dto.getId());
    return transactionMapper.toDTO(transactionRepository.save(transactionMapper.toEntity(dto)));
  }

  /**
   * Save a new transaction.
   *
   * @param dto The transaction data to be saved.
   * @return The newly created transaction.
   * @throws DuplicateResourceException If a transaction with the given ID already exists.
   * @throws ResourceNotFoundException  If the invoice with the given name is not found.
   */
  @Override
  public TransactionDTO saveNewTransaction(TransactionDTO dto) {
    if (transactionRepository.existsById(dto.getId())) {
      throw new DuplicateResourceException("Transaction already exists with the given id: " + dto.getId());
    }

    Invoice invoice = invoiceService.findByName(dto.getInvoiceName());
    if (invoice == null) {
      throw new ResourceNotFoundException("Invoice with the given name: " + dto.getInvoiceName() + " was not found");
    }

    return transactionMapper.toDTO(transactionRepository.save(transactionMapper.toEntity(dto)));
  }

  /**
   * Delete a transaction by ID.
   *
   * @param id The ID of the transaction to delete.
   * @throws ResourceNotFoundException If the transaction with the given ID is not found.
   */
  @Override
  public void deleteTransactionById(Long id) {
    getTransactionById(id);
    transactionRepository.deleteById(id);
  }


  /**
   * Filters transactions based on the specified criteria provided in the {@link TransactionFilterDTO}.
   * It retrieves transactions from the repository that match the filter conditions and maps them to DTOs.
   *
   * @param dto The {@link TransactionFilterDTO} containing filter criteria such as date range, amount range,
   *            payment method type, scheduled payment status, and transaction type.
   * @return A list of {@link TransactionDTO} objects that match the specified filter criteria.
   */
  @Override
  public List<TransactionDTO> filterTransaction(TransactionFilterDTO dto) {
    return transactionRepository.findFilteredTransactions(dto.getMinDate(),
            dto.getMaxDate(),
            dto.getMinAmount(),
            dto.getMaxAmount(),
            dto.getPaymentMethodType(),
            dto.getScheduledPayment(),
            dto.getTransactionType())
        .stream()
        .map(transactionMapper::toDTO)
        .toList();
  }


}

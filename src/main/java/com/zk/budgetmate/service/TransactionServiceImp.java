package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.mapper.TransactionMapper;
import com.zk.budgetmate.model.Invoice;
import com.zk.budgetmate.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService{

  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;
  private final InvoiceService invoiceService;

  @Override
  public List<TransactionDTO> getAllTransactions() {
    return transactionRepository.findAll()
        .stream()
        .map(transactionMapper::toDTO)
        .toList();
  }

  @Override
  public TransactionDTO getTransactionById(Long id) {
    return transactionRepository.findById(id)
        .map(transactionMapper::toDTO)
        .orElseThrow();
  }

  @Override
  public TransactionDTO updateTransactionById(TransactionDTO dto) {
    getTransactionById(dto.getId());
    return transactionMapper.toDTO(transactionRepository.save(transactionMapper.toEntity(dto)));
  }

  //TODO: doesn't save because of name relations between Category and Transaction entity!
  @Override
  public TransactionDTO saveNewTransaction(TransactionDTO dto) throws BadAttributeValueExpException {
    if (transactionRepository.existsTransactionById(dto.getId())) {
      throw new BadAttributeValueExpException("Category is already exist with the given name");
    }

    Invoice invoice = invoiceService.findByName(dto.getInvoiceName());
    if (invoice == null) {
      throw new RuntimeException("Invoice with the given name: " + dto.getInvoiceName() + " was not found");
    }

    return transactionMapper.toDTO(transactionRepository.save(transactionMapper.toEntity(dto)));
  }

  @Override
  public void deleteTransactionById(Long id) {
    getTransactionById(id);
    transactionRepository.deleteById(id);
  }
}

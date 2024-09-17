package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.InvoiceDTO;
import com.zk.budgetmate.exception.DuplicateResourceException;
import com.zk.budgetmate.exception.ResourceNotFoundException;
import com.zk.budgetmate.mapper.InvoiceMapper;
import com.zk.budgetmate.model.Invoice;
import com.zk.budgetmate.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImp implements InvoiceService {

  private final InvoiceRepository invoiceRepository;
  private final InvoiceMapper invoiceMapper;


  public Invoice findByName(String name) {
    return invoiceRepository.findByName(name);
  }

  @Override
  public List<InvoiceDTO> getAllInvoices() {
    return invoiceRepository.findAll()
        .stream()
        .map(invoiceMapper::toDTO)
        .toList();
  }

  @Override
  public InvoiceDTO getInvoiceById(Long id) {
    return invoiceRepository.findById(id)
        .map(invoiceMapper::toDTO)
        .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with the given id: " + id));
  }

  @Override
  public InvoiceDTO saveNewInvoice(InvoiceDTO dto) {
    if (invoiceRepository.existsByName(dto.getName())) {
      throw new DuplicateResourceException("Invoice with the given name: " + dto.getName() + " is already exists");
    }
    return invoiceMapper.toDTO(invoiceRepository.save(invoiceMapper.toEntity(dto)));
  }

  public void deleteInvoiceById(Long id) {
    if (!invoiceRepository.existsById(id)) {
      throw new ResourceNotFoundException("Invoice not found with the given id: " + id);
    }
    invoiceRepository.deleteById(id);
  }


}

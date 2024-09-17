package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.InvoiceDTO;
import com.zk.budgetmate.mapper.InvoiceMapper;
import com.zk.budgetmate.model.Invoice;
import com.zk.budgetmate.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
  public Optional<InvoiceDTO> getInvoiceById(Long id) {
    return invoiceRepository.findById(id)
        .map(invoiceMapper::toDTO);
  }

  @Override
  public InvoiceDTO saveNewInvoice(InvoiceDTO dto) {
    return invoiceMapper.toDTO(invoiceRepository.save(invoiceMapper.toEntity(dto)));
  }

  public void deleteInvoiceById(Long id) {
    invoiceRepository.deleteById(id);
  }


}

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


  /**
   * Retrieves an invoice by name.
   *
   * @param name The name of the invoice to retrieve.
   * @return The invoice with the specified name, or null if no such invoice exists.
   */
  public Invoice findByName(String name) {
    return invoiceRepository.findByName(name)
        .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with the given name: " + name));
  }

  /**
   * Retrieve all invoices.
   *
   * @return a list of all invoices.
   */
  @Override
  public List<InvoiceDTO> getAllInvoices() {
    return invoiceRepository.findAll()
        .stream()
        .map(invoiceMapper::toDTO)
        .toList();
  }

  /**
   * Retrieve an invoice by ID.
   *
   * @param id The ID of the invoice to retrieve.
   * @return The invoice with the specified ID.
   * @throws ResourceNotFoundException If the invoice with the given ID is not found.
   */
  @Override
  public InvoiceDTO getInvoiceById(Long id) {
    return invoiceRepository.findById(id)
        .map(invoiceMapper::toDTO)
        .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with the given id: " + id));
  }

  @Override
  public InvoiceDTO getInvoiceByName(String name) {
    return invoiceRepository.findByName(name)
        .map(invoiceMapper::toDTO)
        .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with the given name: " + name));
  }

  /**
   * Save a new invoice.
   *
   * @param dto The invoice data to be saved.
   * @return The newly created invoice.
   * @throws DuplicateResourceException If a invoice with the given name already exists.
   */
  @Override
  public InvoiceDTO saveNewInvoice(InvoiceDTO dto) {
    if (invoiceRepository.existsByName(dto.getName())) {
      throw new DuplicateResourceException("Invoice with the given name: " + dto.getName() + " is already exists");
    }
    return invoiceMapper.toDTO(invoiceRepository.save(invoiceMapper.toEntity(dto)));
  }


  /**
   * Updates an existing invoice.
   *
   * @param dto The invoice data transfer object (DTO) containing the updated information.
   * @return The updated invoice as a DTO.
   * @throws ResourceNotFoundException If the invoice with the given ID does not exist.
   */
  @Override
  public InvoiceDTO updateInvoiceById(InvoiceDTO dto) {
    getInvoiceById(dto.getId());
    return invoiceMapper.toDTO(invoiceRepository.save(invoiceMapper.toEntity(dto)));
  }

  /**
   * Delete a invoice by ID.
   *
   * @param id The ID of the invoice to delete.
   * @throws ResourceNotFoundException If the invoice with the given ID is not found.
   */
  public void deleteInvoiceById(Long id) {
    if (!invoiceRepository.existsById(id)) {
      throw new ResourceNotFoundException("Invoice not found with the given id: " + id);
    }
    invoiceRepository.deleteById(id);
  }


}

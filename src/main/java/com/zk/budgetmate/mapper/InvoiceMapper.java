package com.zk.budgetmate.mapper;

import com.zk.budgetmate.DTO.InvoiceDTO;
import com.zk.budgetmate.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InvoiceMapper {

  /**
   * Converts an Invoice entity to an InvoiceDTO.
   *
   * @param entity the Invoice entity to be converted.
   * @return InvoiceDTO containing information based on Invoice entity.
   */

  public InvoiceDTO toDTO(Invoice entity) {
    return InvoiceDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .balance(entity.getBalance())
        .user(entity.getUser())
        .transactions(entity.getTransactions())
        .build();
  }


  /**
   * Converts an InvoiceDTO to and Invoice entity.
   *
   * @param dto the InvoiceDTO to be converted.
   * @return Invoice entity containing information based on InvoiceDTO.
   */

  public Invoice toEntity(InvoiceDTO dto) {
    return Invoice.builder()
        .id(dto.getId())
        .name(dto.getName())
        .balance(dto.getBalance())
        .user(dto.getUser())
        .transactions(dto.getTransactions())
        .build();
  }
}

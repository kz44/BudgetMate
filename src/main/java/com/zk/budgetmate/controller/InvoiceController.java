package com.zk.budgetmate.controller;

import com.zk.budgetmate.DTO.InvoiceDTO;
import com.zk.budgetmate.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

  private final InvoiceService invoiceService;

  @GetMapping
  public ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
    return ResponseEntity.ok(invoiceService.getAllInvoices());
  }

  @GetMapping("/{id}")
  public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {
    return ResponseEntity.ok(invoiceService.getInvoiceById(id));
  }

  @PostMapping
  public ResponseEntity<InvoiceDTO> saveNewInvoice(@RequestBody InvoiceDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.saveNewInvoice(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteInvoiceById(@PathVariable Long id) {
    invoiceService.deleteInvoiceById(id);
    return ResponseEntity.noContent().build();
  }
}

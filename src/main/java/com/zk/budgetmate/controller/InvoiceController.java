package com.zk.budgetmate.controller;

import com.zk.budgetmate.DTO.InvoiceDTO;
import com.zk.budgetmate.DTO.TransactionDTO;
import com.zk.budgetmate.service.InvoiceService;
import jakarta.validation.Valid;
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

  /**
   * This endpoint retrieve all invoices.
   *
   * @return a list of all invoices.
   */
  @GetMapping
  public ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
    return ResponseEntity.ok(invoiceService.getAllInvoices());
  }

  /**
   * This endpoint retrieve a specific invoice by ID.
   *
   * @param id The ID of the invoice to retrieve.
   * @return The invoice with the specified ID.
   */
  @GetMapping("/{id}")
  public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {
    return ResponseEntity.ok(invoiceService.getInvoiceById(id));
  }




  /**
   * This endpoint update a invoice with the given ID.
   *
   * @param id  The ID of the Invoice to update.
   * @param dto The new Invoice data.
   * @return The updated invoice.
   */
  @PutMapping("/{id}")
  public ResponseEntity<InvoiceDTO> updateInvoiceById(@PathVariable Long id,
                                                      @Valid @RequestBody InvoiceDTO dto) {
    dto.setId(id);
    return ResponseEntity.ok(invoiceService.updateInvoiceById(dto));
  }


  // javadoc
  @GetMapping("/name")
  public ResponseEntity<InvoiceDTO> getInvoiceByName(@RequestParam String name) {
    return ResponseEntity.ok(invoiceService.getInvoiceByName(name));
  }

  /**
   * This endpoint create a new invoice.
   *
   * @param dto The invoice data to create.
   * @return The created invoice.
   */
  @PostMapping
  public ResponseEntity<InvoiceDTO> saveNewInvoice(@RequestBody InvoiceDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.saveNewInvoice(dto));
  }

  /**
   * This endpoint delete a invoice by ID.
   *
   * @param id The ID of the invoice to delete.
   * @return No content, indicating the invoice was successfully deleted.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteInvoiceById(@PathVariable Long id) {
    invoiceService.deleteInvoiceById(id);
    return ResponseEntity.noContent().build();
  }
}

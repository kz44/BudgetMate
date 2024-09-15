package com.zk.budgetmate.controller;

import com.zk.budgetmate.DTO.CategoryDTO;
import com.zk.budgetmate.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;

  /**
   * Handles HTTP GET requests to retrieve all categories.
   * <p>
   * This endpoint returns all CategoryDTO objects and returns them in the response body.
   * </p>
   *
   * @return a ResponseEntity containing a list of CategoryDTO objects with HTTP status 200 OK
   */
  @GetMapping
  public ResponseEntity<List<CategoryDTO>> getAllCategories() {
    return ResponseEntity.ok(categoryService.getAllCategories());
  }

  /**
   * Handles HTTP GET request to retrieve a Category by the given id.
   * <p>
   * This endpoint return a CategoryDTO object by the given id and return in the response body.
   * </p>
   *
   * @param id specify the category
   * @return a ResponseEntity containing a CategoryDTO by the given id with HTTP status 200 OK
   */
  @GetMapping("/{id}")
  public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
    return ResponseEntity.ok(categoryService.getCategoryById(id));
  }

  /**
   * Handles HTTP PUT request to modify a Category by the given id.
   * <p>
   * This endpoint return the modified CategoryDTO object,
   * that representing the modified Category entity in the response body.
   * </p>
   *
   * @param id  specify the category
   * @param dto containing the information about the Category
   * @return a ResponseEntity containing the modified CategoryDTo by the given id with HTTP status 200 OK
   */
  @PutMapping("/{id}")
  public ResponseEntity<CategoryDTO> updateCategoryById(@PathVariable Long id,
                                                        @Valid @RequestBody CategoryDTO dto) {
    dto.setId(id);
    return ResponseEntity.ok(categoryService.updateCategoryById(dto));
  }

  /**
   * Handles HTTP POST request to add a new Category.
   * <p>
   * This endpoint return the newly created CategoryDTO object,
   * that representing the newly created Category entity in the response body.
   * </p>
   *
   * @param dto containing the information about the new Category.
   * @return a ResponseEntity containing the newly created CategoryDTO by the given Category with HTTP status CREATED.
   */
  @PostMapping()
  public ResponseEntity<CategoryDTO> saveNewCategory(@RequestBody CategoryDTO dto) throws BadAttributeValueExpException {
    return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveNewCategory(dto));
  }

  /**
   * Handles HTTP DELETE request to delete a Category by the given id.
   * <p>
   *   This endpoint returns a message if the Category was successfully deleted.
   * </p>
   * @param id specify the category
   * @return a ResponseEntity with no content, just a message about Category was deleted.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) {
    categoryService.deleteCategoryById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category was successfully deleted");
  }
}

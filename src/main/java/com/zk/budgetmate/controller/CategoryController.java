package com.zk.budgetmate.controller;

import com.zk.budgetmate.DTO.CategoryDTO;
import com.zk.budgetmate.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;


  /**
   * This endpoint retrieve all categories.
   *
   * @return a list of all categories.
   */
  @GetMapping
  public ResponseEntity<List<CategoryDTO>> getAllCategories() {
    return ResponseEntity.ok(categoryService.getAllCategories());
  }

  /**
   * This endpoint retrieve a specific category by ID.
   *
   * @param id The ID of the category to retrieve.
   * @return The category with the specified ID.
   */
  @GetMapping("/{id}")
  public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable final Long id) {
    return ResponseEntity.ok(categoryService.getCategoryById(id));
  }


  /**
   * This endpoint update a category with the given ID.
   *
   * @param id  The ID of the category to update.
   * @param dto The new category data.
   * @return The updated category.
   */
  @PutMapping("/{id}")
  public ResponseEntity<CategoryDTO> updateCategoryById(@PathVariable final Long id,
                                                        @Valid @RequestBody CategoryDTO dto) {
    dto.setId(id);
    return ResponseEntity.ok(categoryService.updateCategoryById(dto));
  }


  /**
   * This endpoint create a new category.
   *
   * @param dto The category data to create.
   * @return The created category.
   */
  @PostMapping()
  public ResponseEntity<CategoryDTO> saveNewCategory(@Valid @RequestBody CategoryDTO dto) {
    return ResponseEntity.ok(categoryService.saveNewCategory(dto));
  }

  /**
   * This endpoint delete a category by ID.
   *
   * @param id The ID of the category to delete.
   * @return No content, indicating the category was successfully deleted.
   */

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCategoryById(@PathVariable final Long id) {
    categoryService.deleteCategoryById(id);
    return ResponseEntity.noContent().build();
  }
}

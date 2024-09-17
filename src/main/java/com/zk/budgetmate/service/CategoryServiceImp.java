package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.CategoryDTO;
import com.zk.budgetmate.exception.DuplicateResourceException;
import com.zk.budgetmate.exception.ResourceNotFoundException;
import com.zk.budgetmate.mapper.CategoryMapper;
import com.zk.budgetmate.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  /**
   * Retrieve all categories.
   *
   * @return a list of all categories.
   */
  @Override
  public List<CategoryDTO> getAllCategories() {
    return categoryRepository.findAll()
        .stream()
        .map(categoryMapper::toDto)
        .toList();
  }

  /**
   * Retrieve a category by ID.
   *
   * @param id The ID of the category to retrieve.
   * @return The category with the specified ID.
   * @throws ResourceNotFoundException If the category with the given ID is not found.
   */
  @Override
  public CategoryDTO getCategoryById(Long id) {
    return categoryRepository.findById(id)
        .map(categoryMapper::toDto)
        .orElseThrow(() -> new ResourceNotFoundException("Category was not found with the given id: " + id));
  }

  /**
   * Update an existing category.
   *
   * @param dto The updated category data.
   * @return The updated category.
   * @throws ResourceNotFoundException If the category with the given ID is not found.
   */
  @Override
  public CategoryDTO updateCategoryById(CategoryDTO dto) {
    if (dto.getId() == null || !categoryRepository.existsById(dto.getId())) {
      throw new ResourceNotFoundException("Category was not found with the given id: " + dto.getId());
    }

    return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
  }


  /**
   * Save a new category.
   *
   * @param dto The category data to be saved.
   * @return The newly created category.
   * @throws DuplicateResourceException If a category with the given name already exists.
   */
  @Override
  public CategoryDTO saveNewCategory(CategoryDTO dto) {
    if (categoryRepository.existsByName(dto.getName())) {
      throw new DuplicateResourceException("Category already exists with the name: " + dto.getName());
    }
    return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
  }

  /**
   * Delete a category by ID.
   *
   * @param id The ID of the category to delete.
   * @throws ResourceNotFoundException If the category with the given ID is not found.
   */
  @Override
  public void deleteCategoryById(Long id) {
    if (!categoryRepository.existsById(id)) {
      throw new ResourceNotFoundException("Category not found with id: " + id);
    }
    categoryRepository.deleteById(id);
  }


}

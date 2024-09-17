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
   * Retrieves all categories and converts them into a list of CategoryDTO objects.
   * <p>
   * This method fetches all the Category entities from the repository,
   * maps them to CategoryDTO objects using the custom transform CategoryMapper,
   * and returns the list of these DTOs.
   * </p>
   *
   * @return list of CategoryDTO representing all categories
   */
  @Override
  public List<CategoryDTO> getAllCategories() {
    return categoryRepository.findAll()
        .stream()
        .map(categoryMapper::toDto)
        .toList();
  }

  /**
   * Retrieves a category and converts into a CategoryDTO objects.
   * <p>
   * This method fetches a Category entity by the given id from the repository,
   * maps it to a CategoryDTO object using the custom transform CategoryMapper,
   * and returns a CategoryDTO.
   * </p>
   *
   * @return a CategoryDTO by the given id representing category entity.
   */
  @Override
  public CategoryDTO getCategoryById(Long id) {
    return categoryRepository.findById(id)
        .map(categoryMapper::toDto)
        .orElseThrow(() -> new ResourceNotFoundException("Category was not found with the given id: " + id));
  }

  /**
   * Updates an existing category based on the provided CategoryDTO.
   * <p>
   * This method first checks if the category with the given ID exists.
   * If the category exists, it converts the CategoryDTO to an entity using the categoryMapper.
   * Updates the category, and then returns the updated entity as a DTO.
   * </p>
   *
   * @param dto CategoryDTO containing the updated category data.
   * @return The updated CategoryDTO after the changes have been persisted.
   * @throws IllegalArgumentException If the provided CategoryDTO is null or invalid.
   */
  @Override
  public CategoryDTO updateCategoryById(CategoryDTO dto) {
    if (dto.getId() == null || !categoryRepository.existsById(dto.getId())) {
      throw new ResourceNotFoundException("Category was not found with the given id: " + dto.getId());
    }

    return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
  }


  @Override
  public CategoryDTO saveNewCategory(CategoryDTO dto) {
    if (categoryRepository.existsByName(dto.getName())) {
      throw new DuplicateResourceException("Category already exists with the name: " + dto.getName());
    }
    return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(dto)));
  }


  @Override
  public void deleteCategoryById(Long id) {
    if (!categoryRepository.existsById(id)) {
      throw new ResourceNotFoundException("Category not found with id: " + id);
    }
    categoryRepository.deleteById(id);
  }


}

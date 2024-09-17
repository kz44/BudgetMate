package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.CategoryDTO;

import javax.management.BadAttributeValueExpException;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> getAllCategories();

  CategoryDTO getCategoryById(Long id);

  CategoryDTO updateCategoryById(CategoryDTO dto);

  CategoryDTO saveNewCategory(CategoryDTO dto);

  void deleteCategoryById(Long id);
}

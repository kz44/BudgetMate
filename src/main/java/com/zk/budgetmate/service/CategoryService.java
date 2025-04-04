package com.zk.budgetmate.service;

import com.zk.budgetmate.DTO.CategoryDTO;
import com.zk.budgetmate.model.Category;
import com.zk.budgetmate.model.Invoice;

import javax.management.BadAttributeValueExpException;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> getAllCategories();

  CategoryDTO getCategoryById(Long id);

  CategoryDTO updateCategoryById(CategoryDTO dto);

  CategoryDTO saveNewCategory(CategoryDTO dto);

  void deleteCategoryById(Long id);

  Category findByName(String name);
}

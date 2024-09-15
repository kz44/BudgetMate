package com.zk.budgetmate.mapper;

import com.zk.budgetmate.DTO.CategoryDTO;
import com.zk.budgetmate.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryMapper {

  /**
   * Converts a Category entity to a CategoryDTO.
   *
   * @param entity the Category entity to be converted.
   * @return CategoryDTO containing information based on Category entity.
   */

  public CategoryDTO toDto(Category entity) {
    return CategoryDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .build();
  }

  /**
   * Converts a CategoryDTO to a Category entity.
   *
   * @param dto the CategoryDTO to be converted.
   * @return Category entity containing information based on CategoryDTO.
   */
  public Category toEntity(CategoryDTO dto) {
    return Category.builder()
        .id(dto.getId())
        .name(dto.getName())
        .description(dto.getDescription())
        .build();
  }
}

package com.zk.budgetmate.service;

import com.zk.budgetmate.mapper.CategoryMapper;
import com.zk.budgetmate.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService{

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;
}

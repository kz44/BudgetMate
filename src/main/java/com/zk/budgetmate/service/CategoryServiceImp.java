package com.zk.budgetmate.service;

import com.zk.budgetmate.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp {

  private final CategoryRepository categoryRepository;
}

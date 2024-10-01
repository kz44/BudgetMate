package com.zk.budgetmate.repository;

import com.zk.budgetmate.model.Category;
import com.zk.budgetmate.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  boolean existsByName(final String name);

  Category findByName(final String name);
}

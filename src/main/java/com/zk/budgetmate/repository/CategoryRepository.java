package com.zk.budgetmate.repository;

import com.zk.budgetmate.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}

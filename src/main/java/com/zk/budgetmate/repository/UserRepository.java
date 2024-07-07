package com.zk.budgetmate.repository;

import com.zk.budgetmate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

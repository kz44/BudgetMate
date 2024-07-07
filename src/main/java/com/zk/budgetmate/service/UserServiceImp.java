package com.zk.budgetmate.service;

import com.zk.budgetmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp {

  private final UserRepository userRepository;
}

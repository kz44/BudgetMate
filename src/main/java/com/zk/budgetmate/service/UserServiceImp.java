package com.zk.budgetmate.service;

import com.zk.budgetmate.model.User;
import com.zk.budgetmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;

  public User getUserByUsername (String username){
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
  }
}

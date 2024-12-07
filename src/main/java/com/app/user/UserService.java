package com.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepo userRepo;
  private final PasswordEncoder passwordEncoder;

  public User create(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    User saved = userRepo.save(user);
    return saved;
  }

  public User findUserByUserName(String username) throws UsernameNotFoundException {
    return userRepo
        .findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User Not Found"));
  }
}

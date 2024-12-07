package com.app.auth.request;

import com.app.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequest {
  private String username;
  private String password;
  private String phoneNumber;
  private String fullName;

  public User toUser() {
    User user = new User();
    user.setUsername(this.username);
    user.setPassword(this.password);
    user.setPhoneNumber(this.phoneNumber);
    user.setFullName(this.fullName);
    return user;
  }
}

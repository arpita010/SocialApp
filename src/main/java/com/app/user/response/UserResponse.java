package com.app.user.response;

import com.app.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
  private Long userId;
  private String username;
  private String phoneNumber;
  private String fullName;

  public UserResponse(User user) {
    this.userId = user.getId();
    this.username = user.getUsername();
    this.phoneNumber = user.getPhoneNumber();
    this.fullName = user.getFullName();
  }
}

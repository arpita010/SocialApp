package com.app.auth;

import com.app.auth.request.SigninRequest;
import com.app.auth.request.SignupRequest;
import com.app.auth.response.SigninResponse;
import com.app.jwt.JwtHelper;
import com.app.user.User;
import com.app.user.UserService;
import com.app.user.response.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final UserService userService;
  private final UserDetailsService userDetailsService;
  private final AuthenticationManager manager;
  private final JwtHelper jwtHelper;

  @PostMapping("/signin")
  public ResponseEntity<SigninResponse> login(@RequestBody SigninRequest request) {
    doAuthenticate(request.getUsername(), request.getPassword());
    UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
    String token = jwtHelper.generateToken(userDetails);
    SigninResponse response = new SigninResponse(userDetails.getUsername(), token);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  private void doAuthenticate(String email, String password) {
    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(email, password);
    try {
      manager.authenticate(authentication);
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException(" Invalid Username or Password  !!");
    }
  }

  @PostMapping("/signup")
  public UserResponse signup(@RequestBody SignupRequest request) {
    User user = request.toUser();
    User createdUser = userService.create(user);
    return new UserResponse(createdUser);
  }

  @GetMapping("/fetchCurrentUser")
  public UserResponse getCurrentUser(HttpServletRequest request) {
    String authToken = request.getHeader("Authorization").substring(7);
    String username = jwtHelper.getUsernameFromToken(authToken);
    User user = userService.findUserByUserName(username);
    return new UserResponse(user);
  }
}

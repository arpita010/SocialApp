package com.app.jwt;

import com.app.exceptions.AuthException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException, ServletException {
    log.error("Error while processing the Http Request : {}", authException.getMessage());
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    throw new AuthException("Authentication Failed due to " + authException.getMessage());
  }
}

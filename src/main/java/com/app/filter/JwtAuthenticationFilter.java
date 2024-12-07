package com.app.filter;

import com.app.exceptions.AuthException;
import com.app.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final JwtService jwtService;

  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization");
    String method = request.getMethod();
    log.info("Request Method : {}", method);
    log.info("Authorization Header : {}", authHeader);
    String requestURI = request.getRequestURI();
    log.info("Requested Resource : {}", requestURI);
    String username = null;
    String token = null;
    if (!method.equals("OPTIONS")) {
      checkIfAuthTokenIsValid(authHeader);
      token = authHeader.substring(7);
      username = jwtService.getUsernameFromToken(token);
      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Boolean validateToken = jwtService.validateToken(token, userDetails);
        if (validateToken) {
          UsernamePasswordAuthenticationToken authentication =
              new UsernamePasswordAuthenticationToken(
                  userDetails, null, userDetails.getAuthorities());
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
          logger.info("Validation fails !!");
          throw new AuthException("Validation Failed. Invalid Auth Token.");
        }
      }
    }
    setRequiredHeaders(response);
    filterChain.doFilter(request, response);
    setRequiredHeaders(response);
  }

  private void checkIfAuthTokenIsValid(String authHeader) {
    if (authHeader != null && authHeader.startsWith("Bearer")) {
      String token = authHeader.substring(7);
      String username = jwtService.getUsernameFromToken(token);
    } else {
      log.info("Invalid Auth Token");
      throw new RuntimeException("Invalid Auth Token");
    }
  }

  private void setRequiredHeaders(HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
    response.setHeader(
        "Access-Control-Allow-Headers",
        "Content-Type, Authorization, access-control-allow-origin, content-type, authorization, access-control-allow-headers");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_OK);
  }
}

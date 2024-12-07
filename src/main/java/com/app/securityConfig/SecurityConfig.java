package com.app.securityConfig;

import com.app.filter.JwtAuthenticationFilter;
import com.app.jwt.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Autowired private JwtAuthenticationEntryPoint point;
  @Autowired private JwtAuthenticationFilter filter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.disable())
        .cors(cor -> cor.disable())
        .authorizeRequests()
        .requestMatchers("/test")
        .authenticated()
        .requestMatchers("/user/getAll")
        .authenticated()
        .requestMatchers("/auth/login")
        .permitAll()
        .requestMatchers("/user/create")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}

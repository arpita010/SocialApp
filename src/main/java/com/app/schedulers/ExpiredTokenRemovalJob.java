package com.app.schedulers;

import com.app.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpiredTokenRemovalJob {
  private final JwtService jwtService;

  // once a month
  public void removeBlackListedTokensFromBucket() {}
}

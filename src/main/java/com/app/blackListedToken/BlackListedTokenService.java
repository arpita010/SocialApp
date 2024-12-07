package com.app.blackListedToken;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlackListedTokenService {
  private final BlackListedTokenRepo blackListedTokenRepo;

  public List<BlackListedToken> findAll() {
    List<BlackListedToken> list = new ArrayList<>();
    blackListedTokenRepo.findAll().forEach(list::add);
    return list;
  }

  public boolean isBlackListed(String token) {
    Optional<BlackListedToken> opt = blackListedTokenRepo.findByToken(token);
    return opt.isPresent();
  }

  public void blacklistToken(String token)
  {
    BlackListedToken blackListedToken = new BlackListedToken();
    blackListedToken.setToken(token);
    blackListedTokenRepo.save(blackListedToken);
  }
}

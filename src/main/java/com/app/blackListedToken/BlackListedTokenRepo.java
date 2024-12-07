package com.app.blackListedToken;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlackListedTokenRepo extends CrudRepository<BlackListedToken, Long> {
    Optional<BlackListedToken> findByToken(String token);
}

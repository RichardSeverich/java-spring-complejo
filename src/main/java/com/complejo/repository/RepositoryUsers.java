package com.complejo.repository;

import com.complejo.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryUsers extends RepositoryGeneric<User> {

  @Query(value = "SELECT * FROM users WHERE username = ?1 AND password = ?2", nativeQuery = true)
  Iterable<User> findUsers(String userName, String password);
}

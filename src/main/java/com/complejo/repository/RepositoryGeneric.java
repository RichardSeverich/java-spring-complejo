package com.complejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface.
 */
@NoRepositoryBean
public interface RepositoryGeneric<T> extends JpaRepository<T, Integer> {

}

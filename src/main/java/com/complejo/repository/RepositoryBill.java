package com.complejo.repository;

import com.complejo.models.Bill;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface.
 */
@Repository
public interface RepositoryBill extends RepositoryGeneric<Bill> {

  @Query(value = "SELECT "
      + "bills.* "
      + "FROM bills "
      + "WHERE bills_date = ?1 ", nativeQuery = true)
  Iterable<Bill> findBillsByBillDate(String billDate);
}

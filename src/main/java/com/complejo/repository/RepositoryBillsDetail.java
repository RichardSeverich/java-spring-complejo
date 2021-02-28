package com.complejo.repository;

import com.complejo.models.BillsDetail;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface.
 */
@Repository
public interface RepositoryBillsDetail extends RepositoryGeneric<BillsDetail> {

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "INSERT INTO bills_detail "
      + "(id_booking, id_bill, created_by) "
      + "VALUES ( ?1 , ?2 , ?3 )", nativeQuery = true)
  public void insertBillDetails(Integer idBooking, Integer idBill, String createdBy);
}

package com.complejo.repository;

import com.complejo.models.Booking;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface.
 */
@Repository
public interface RepositoryBookings extends RepositoryGeneric<Booking> {

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "UPDATE bookings "
      + "SET billed = 1 "
      + "WHERE id = ?1", nativeQuery = true)
  public void updateBilled(Integer idBooking);
}

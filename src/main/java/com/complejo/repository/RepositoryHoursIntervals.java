package com.complejo.repository;

import com.complejo.models.HoursInterval;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryHoursIntervals extends RepositoryGeneric<HoursInterval> {

  @Query(value = "SELECT hours_intervals.* "
      + "FROM hours_intervals "
      + "WHERE hours_intervals.id "
      + "NOT IN ("
      + "SELECT bookings.id_hours_interval "
      + "FROM bookings "
      + "WHERE bookings.id_resource = ?1 "
      + "AND bookings.booking_date = ?2 )", nativeQuery = true)
  Iterable<HoursInterval> findAvaliableHours(Integer idResource, String bookingDate);
}

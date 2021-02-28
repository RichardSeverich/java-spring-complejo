package com.complejo.repository;

import com.complejo.models.BookingsResourcesHoursJoin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryBookingsResourcesHoursJoin extends RepositoryGeneric<BookingsResourcesHoursJoin> {

  @Query(value = "SELECT "
      + "bookings.id,"
      + "hours_intervals.name AS `hours_interval_name`,"
      + "bookings.comments,"
      + "bookings.billed,"
      + "bookings.creation_date,"
      + "bookings.update_date,"
      + "bookings.created_by,"
      + "bookings.updated_by "
      + "FROM hours_intervals "
      + "INNER JOIN bookings "
      + "ON hours_intervals.id=bookings.id_hours_interval "
      + "INNER JOIN resources "
      + "ON resources.id=bookings.id_resource "
      + "WHERE bookings.id_resource = ?1 "
      + "AND bookings.booking_date = ?2", nativeQuery = true)
  Iterable<BookingsResourcesHoursJoin> findReservedHours(Integer idResource, String bookingDate);
}

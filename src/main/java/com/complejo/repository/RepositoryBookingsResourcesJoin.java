package com.complejo.repository;

import com.complejo.models.BookingsResourcesJoin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryBookingsResourcesJoin extends RepositoryGeneric<BookingsResourcesJoin> {

  @Query(value = "SELECT "
      + "bookings.id,"
      + "bookings.comments,"
      + "resources.name AS `resource_name`,"
      + "resources.price_hour,"
      + "hours_intervals.name AS `hours_interval_name`,"
      + "bookings.creation_date,"
      + "bookings.update_date,"
      + "bookings.created_by,"
      + "bookings.updated_by "
      + "FROM hours_intervals "
      + "INNER JOIN bookings "
      + "ON hours_intervals.id=bookings.id_hours_interval "
      + "INNER JOIN resources "
      + "ON resources.id=bookings.id_resource "
      + "WHERE bookings.booking_date = ?1", nativeQuery = true)
  Iterable<BookingsResourcesJoin> findResourcesByBookingDate(String bookingDate);

  @Query(value = "SELECT "
      + "bookings.id,"
      + "bookings.comments,"
      + "resources.name AS `resource_name`,"
      + "resources.price_hour,"
      + "hours_intervals.name AS `hours_interval_name`,"
      + "bookings.creation_date,"
      + "bookings.update_date,"
      + "bookings.created_by,"
      + "bookings.updated_by "
      + "FROM hours_intervals "
      + "INNER JOIN bookings "
      + "ON hours_intervals.id=bookings.id_hours_interval "
      + "INNER JOIN resources "
      + "ON resources.id=bookings.id_resource "
      + "WHERE bookings.booking_date = ?1 "
      + "AND bookings.created_by = ?2 "
      + "AND bookings.billed = false", nativeQuery = true)
  Iterable<BookingsResourcesJoin> findResourcesByBookingDateAndUserName(String bookingDate, String userName);

  @Query(value = "SELECT "
      + "bills_detail.id,"
      + "bookings.comments,"
      + "resources.name AS `resource_name`,"
      + "resources.price_hour,"
      + "hours_intervals.name AS `hours_interval_name`,"
      + "bills_detail.creation_date,"
      + "bills_detail.update_date,"
      + "bills_detail.created_by,"
      + "bills_detail.updated_by "
      + "FROM hours_intervals "
      + "INNER JOIN bookings "
      + "ON hours_intervals.id=bookings.id_hours_interval "
      + "INNER JOIN resources "
      + "ON resources.id=bookings.id_resource "
      + "INNER JOIN bills_detail "
      + "ON bookings.id=bills_detail.id_booking "
      + "INNER JOIN bills "
      + "ON bills.id=bills_detail.id_bill "
      + "WHERE bills.bills_date = ?1 "
      + "AND bills_detail.id_bill = ?2", nativeQuery = true)
  Iterable<BookingsResourcesJoin> findResourcesByBillDateAndIdBill(String billDate, int idBill);
}

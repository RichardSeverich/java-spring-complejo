package com.complejo.repository;

import com.complejo.models.RevenueMonth;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryReportsRevenues extends RepositoryGeneric<RevenueMonth> {

    @Query(value = "SELECT "
    + "?1 AS id, "
    + "?3 AS month, "
    + "SUM(resources.price_hour) AS revenue "
    + "FROM resources "
    + "INNER JOIN bookings "
    + "ON resources.id = bookings.id_resource  "
    + "WHERE MONTH(bookings.booking_date) = ?1 "
    + "AND YEAR(bookings.booking_date) = ?2", nativeQuery = true)
RevenueMonth findReportByMonth(Integer month, Integer year, String nameMonth);
}

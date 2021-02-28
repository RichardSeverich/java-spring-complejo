package com.complejo.services;

import com.complejo.models.BookingsResourcesHoursJoin;
import com.complejo.models.BookingFilter;
import com.complejo.helpers.Helper;
import com.complejo.repository.RepositoryBookingsResourcesHoursJoin;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServiceGetFilterReservedHours {

  @Autowired
  private Helper<BookingsResourcesHoursJoin> helper;

  @Autowired
  private ResponseBuilder<BookingsResourcesHoursJoin> responseBuilder;

  @Autowired
  private RepositoryBookingsResourcesHoursJoin repository;

  public Response<BookingsResourcesHoursJoin> getResponse(BookingFilter filter) {
    Iterable<BookingsResourcesHoursJoin> iterable = repository
        .findReservedHours(filter.getIdResource(), filter.getBookingDate());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}

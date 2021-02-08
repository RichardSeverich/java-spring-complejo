package com.complejo.services;

import com.complejo.models.HoursInterval;
import com.complejo.models.BookingFilter;
import com.complejo.helpers.Helper;
import com.complejo.repository.RepositoryHoursIntervals;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServiceGetFilterAvaliableHours {

  @Autowired
  private Helper<HoursInterval> helper;

  @Autowired
  private ResponseBuilder<HoursInterval> responseBuilder;

  @Autowired
  private RepositoryHoursIntervals repository;

  public Response<HoursInterval> getResponse(BookingFilter filter) {
    Iterable<HoursInterval> iterable = repository.findAvaliableHours(filter.getIdResource(), filter.getBookingDate());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}

package com.complejo.services;

import com.complejo.helpers.Helper;
import com.complejo.models.BookingsResourcesJoin;
import com.complejo.models.DateFilter;
import com.complejo.repository.RepositoryBookingsResourcesJoin;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import com.complejo.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServiceGetResourcesByBookingDate {

  @Autowired
  private Helper<BookingsResourcesJoin> helper;

  @Autowired
  private ResponseBuilder<BookingsResourcesJoin> responseBuilder;

  @Autowired
  private RepositoryBookingsResourcesJoin repository;

  public Response<BookingsResourcesJoin> getResponse(DateFilter filter) {
    Iterable<BookingsResourcesJoin> iterable = repository.findResourcesByBookingDate(filter.getBookingDate());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}
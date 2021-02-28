package com.complejo.services;

import com.complejo.helpers.Helper;
import com.complejo.models.User;
import com.complejo.models.DateFilter;
import com.complejo.repository.RepositoryUsers;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import com.complejo.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServiceGetFilterUsers {

  @Autowired
  private Helper<User> helper;

  @Autowired
  private ResponseBuilder<User> responseBuilder;

  @Autowired
  private RepositoryUsers repository;

  public Response<User> getResponse(DateFilter filter) {
    Iterable<User> iterable = repository.findFilterUsers(filter.getBookingDate());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}

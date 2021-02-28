package com.complejo.services;

import com.complejo.helpers.Helper;
import com.complejo.models.Bill;
import com.complejo.models.DateFilterBill;
import com.complejo.repository.RepositoryBill;
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
public class ServiceGetForPostBill {

  @Autowired
  private Helper<Bill> helper;

  @Autowired
  private ResponseBuilder<Bill> responseBuilder;

  @Autowired
  private RepositoryBill repository;

  public Response<Bill> getResponse(DateFilterBill filter) {
    Iterable<Bill> iterable = repository.findBillsByBillDate(filter.getBillDate());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}
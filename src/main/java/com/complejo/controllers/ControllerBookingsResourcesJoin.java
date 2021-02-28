package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.BookingsResourcesJoin;
import com.complejo.models.FilterUserNameDate;
import com.complejo.models.FilterBill;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;
import com.complejo.services.ServiceGetFilterResourcesHours;
import com.complejo.services.ServiceGetBillsDetail;
import com.complejo.support.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBookingsResourcesJoin {

  @Autowired
  private ServiceGetFilterResourcesHours serviceGetFilterResourcesHours;

  @Autowired
  private ServiceGetBillsDetail serviceGetBillsDetail;

  /**
  * @param reportsRevenueFilter reportsRevenueFilter.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_RESERVED_RESOURCES)
  public ResponseEntity<ResponseBody<BookingsResourcesJoin>> 
      resourcesHoursByDateBookingAndUserName(final @RequestBody @Valid FilterUserNameDate filter) {
    Response<BookingsResourcesJoin> response = serviceGetFilterResourcesHours.getResponse(filter);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param reportsRevenueFilter reportsRevenueFilter.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_DETAIL)
  public ResponseEntity<ResponseBody<BookingsResourcesJoin>> 
      resourcesHoursByDateBillAndBill(final @RequestBody @Valid FilterBill filter) {
    Response<BookingsResourcesJoin> response = serviceGetBillsDetail.getResponse(filter);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}

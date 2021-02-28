package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.BillForPost;
import com.complejo.models.Bill;
import com.complejo.models.DateFilterBill;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;
import com.complejo.services.ServiceDelete;
import com.complejo.services.ServiceGet;
import com.complejo.services.ServiceGetById;
import com.complejo.services.ServiceGetForPostBill;
import com.complejo.services.ServicePost;
import com.complejo.services.ServicePut;
import com.complejo.services.ServicePostBookingsBilled;
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
public class ControllerBill {
  private static final String ENTITY_NAME = "billForPost";

  @Autowired
  private Helper<BillForPost> helper;
  
  @Autowired
  private ServicePost<BillForPost> servicePost;
  
  @Autowired
  private ServicePostBookingsBilled servicePostBookingsBilled;

  @Autowired
  private ServiceGetForPostBill serviceGetForPostBill;

  /**
  * @param billForPost billForPost.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_BILLS)
  public ResponseEntity<ResponseBody<BillForPost>> add(final @RequestBody @Valid BillForPost bill) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(bill);
    Response<BillForPost> response = servicePostBookingsBilled.getResponse(servicePost, bill);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param bookingFilter bookingFilter.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_BILLS_FILTER_DATE)
  public ResponseEntity<ResponseBody<Bill>> getBillsForDateBill(final @RequestBody @Valid DateFilterBill billDate) {
    Response<Bill> response = serviceGetForPostBill.getResponse(billDate);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}

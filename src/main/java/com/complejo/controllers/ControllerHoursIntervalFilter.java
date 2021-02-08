package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.HoursInterval;
import com.complejo.models.Booking;
import com.complejo.models.BookingFilter;
import com.complejo.models.Resource;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;
import com.complejo.services.ServiceGetFilterAvaliableHours;
import com.complejo.services.ServiceGetFilterReservedHours;
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
public class ControllerHoursIntervalFilter {

  @Autowired
  private ServiceGetFilterAvaliableHours serviceGetFilterAvaliableHours;

  @Autowired
  private ServiceGetFilterReservedHours serviceGetFilterReservedHours;

  /**
  * @param bookingFilter bookingFilter.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_AVALIABLE_HOURS)
  public ResponseEntity<ResponseBody<HoursInterval>> hoursAvaliables(final @RequestBody @Valid BookingFilter bookingFilter) {
    Response<HoursInterval> response = serviceGetFilterAvaliableHours.getResponse(bookingFilter);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param bookingFilter bookingFilter.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_RESERVED_HOURS)
  public ResponseEntity<ResponseBody<HoursInterval>> hoursReserved(final @RequestBody @Valid BookingFilter bookingFilter) {
    Response<HoursInterval> response = serviceGetFilterReservedHours.getResponse(bookingFilter);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}

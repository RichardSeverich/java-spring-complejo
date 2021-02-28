package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.Booking;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;
import com.complejo.services.ServiceDelete;
import com.complejo.services.ServiceGet;
import com.complejo.services.ServiceGetById;
import com.complejo.services.ServicePost;
import com.complejo.services.ServicePut;
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
public class ControllerBooking {
  private static final String ENTITY_NAME = "booking";

  @Autowired
  private ServiceGet<Booking> serviceGet;

  @Autowired
  private ServiceGetById<Booking> serviceGetById;

  @Autowired
  private ServicePost<Booking> servicePost;

  @Autowired
  private ServicePut<Booking> servicePut;

  @Autowired
  private ServiceDelete<Booking> serviceDelete;

  @Autowired
  private Helper<Booking> helper;

  /**
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_BOOKINGS)
  public ResponseEntity<ResponseBody<Booking>> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response<Booking> response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_BOOKINGS_WITH_ID)
  public ResponseEntity<ResponseBody<Booking>> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<Booking> response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param booking booking.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_BOOKINGS)
  public ResponseEntity<ResponseBody<Booking>> add(final @RequestBody @Valid Booking booking) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(booking);
    Response<Booking> response = servicePost.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param booking booking.
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_BOOKINGS_WITH_ID)
  public ResponseEntity<ResponseBody<Booking>>
      update(final @RequestBody @Valid Booking booking, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    helper.setEntity(booking);
    booking.setId(id);
    Response<Booking> response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_BOOKINGS_WITH_ID)
  public ResponseEntity<ResponseBody<Booking>> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<Booking> response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}

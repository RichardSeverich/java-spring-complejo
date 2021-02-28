package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.HoursInterval;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;

import com.complejo.services.ServiceGet;
import com.complejo.services.ServiceGetById;

import com.complejo.support.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHoursInterval {
  private static final String ENTITY_NAME = "hoursInterval";

  @Autowired
  private ServiceGet<HoursInterval> serviceGet;

  @Autowired
  private ServiceGetById<HoursInterval> serviceGetById;

  @Autowired
  private Helper<HoursInterval> helper;

  /**
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_HOURS_INTERVALS)
  public ResponseEntity<ResponseBody<HoursInterval>> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response<HoursInterval> response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_HOURS_INTERVALS_WITH_ID)
  public ResponseEntity<ResponseBody<HoursInterval>> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<HoursInterval> response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}

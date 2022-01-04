package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.RevenueMonth;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;

import com.complejo.services.ServiceReportRevenue;

import com.complejo.support.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerReportsRevenues {
  private static final String ENTITY_NAME = "reportMonth";

  @Autowired
  private ServiceReportRevenue serviceReportRevenue;

  @Autowired
  private Helper<RevenueMonth> helper;

  /**
  * @param year   year.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_REPORTS_REVENUE_WITH_YEAR)
  public ResponseEntity<ResponseBody<RevenueMonth>> getByYear(final @PathVariable Integer year) {
    helper.setId(year);
    Response<RevenueMonth> response = serviceReportRevenue.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}

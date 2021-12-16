package com.complejo.services;

import com.complejo.helpers.Helper;
import com.complejo.models.RevenueMonth;
import com.complejo.repository.RepositoryReportsRevenues;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServiceReportRevenue {

  @Autowired
  private Helper<RevenueMonth> helper;

  @Autowired
  private ResponseBuilder<RevenueMonth> responseBuilder;

  @Autowired
  private RepositoryReportsRevenues repository;

  public Response<RevenueMonth> getResponse() {
    List<String> listMonth = new ArrayList<>(Arrays
        .asList("Enero", "Febrero", "Marzo", "Abril",
                "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"));
    for (int valueListMonth = 0; valueListMonth <= 11; valueListMonth++) {
      helper.getList().add(repository.findReportByMonth((valueListMonth + 1), helper.getId(), listMonth.get(valueListMonth)));
    }
    return responseBuilder.getResponseOkForGet();
  }
}

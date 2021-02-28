package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.BillsDetail;
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
public class ControllerBillDetail {
  private static final String ENTITY_NAME = "billDetail";

  @Autowired
  private ServiceGet<BillsDetail> serviceGet;

  @Autowired
  private ServiceGetById<BillsDetail> serviceGetById;

  @Autowired
  private ServicePost<BillsDetail> servicePost;

  @Autowired
  private ServicePut<BillsDetail> servicePut;

  @Autowired
  private ServiceDelete<BillsDetail> serviceDelete;

  @Autowired
  private Helper<BillsDetail> helper;

  /**
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_BILLS_DETAIL)
  public ResponseEntity<ResponseBody<BillsDetail>> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response<BillsDetail> response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_BILLS_DETAIL_WITH_ID)
  public ResponseEntity<ResponseBody<BillsDetail>> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<BillsDetail> response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param billsDetail billsDetail.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_BILLS_DETAIL)
  public ResponseEntity<ResponseBody<BillsDetail>> add(final @RequestBody @Valid BillsDetail billsDetail) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(billsDetail);
    Response<BillsDetail> response = servicePost.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param billsDetail billsDetail.
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_BILLS_DETAIL_WITH_ID)
  public ResponseEntity<ResponseBody<BillsDetail>>
      update(final @RequestBody @Valid BillsDetail billsDetail, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    helper.setEntity(billsDetail);
    billsDetail.setId(id);
    Response<BillsDetail> response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_BILLS_DETAIL_WITH_ID)
  public ResponseEntity<ResponseBody<BillsDetail>> delete(final @PathVariable Integer id) {
    System.out.println("ENTROOO DELETE BILLS DETAIL");
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<BillsDetail> response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}

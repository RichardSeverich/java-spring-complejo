package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.Resource;
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
public class ControllerResource {
  private static final String ENTITY_NAME = "resource";

  @Autowired
  private ServiceGet<Resource> serviceGet;

  @Autowired
  private ServiceGetById<Resource> serviceGetById;

  @Autowired
  private ServicePost<Resource> servicePost;

  @Autowired
  private ServicePut<Resource> servicePut;

  @Autowired
  private ServiceDelete<Resource> serviceDelete;

  @Autowired
  private Helper<Resource> helper;

  /**
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_RESOURCES)
  public ResponseEntity<ResponseBody<Resource>> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response<Resource> response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_RESOURCES_WITH_ID)
  public ResponseEntity<ResponseBody<Resource>> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<Resource> response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param resource resource.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_RESOURCES)
  public ResponseEntity<ResponseBody<Resource>> add(final @RequestBody @Valid Resource resource) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(resource);
    Response<Resource> response = servicePost.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param resource resource.
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_RESOURCES_WITH_ID)
  public ResponseEntity<ResponseBody<Resource>>
      update(final @RequestBody @Valid Resource resource, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    helper.setEntity(resource);
    resource.setId(id);
    Response<Resource> response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_RESOURCES_WITH_ID)
  public ResponseEntity<ResponseBody<Resource>> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<Resource> response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.User;
import com.complejo.models.DateFilter;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;
import com.complejo.services.ServiceDelete;
import com.complejo.services.ServiceGet;
import com.complejo.services.ServiceGetById;
import com.complejo.services.ServicePost;
import com.complejo.services.ServicePut;
import com.complejo.services.ServiceGetFilterUsers;
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
public class ControllerUser {
  private static final String ENTITY_NAME = "user";

  @Autowired
  private ServiceGet<User> serviceGet;

  @Autowired
  private ServiceGetById<User> serviceGetById;

  @Autowired
  private ServicePost<User> servicePost;

  @Autowired
  private ServicePut<User> servicePut;

  @Autowired
  private ServiceDelete<User> serviceDelete;

  @Autowired
  private ServiceGetFilterUsers serviceGetFilterUsers;

  @Autowired
  private Helper<User> helper;

  /**
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS)
  public ResponseEntity<ResponseBody<User>> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response<User> response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody<User>> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<User> response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param user user.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_USERS)
  public ResponseEntity<ResponseBody<User>> add(final @RequestBody @Valid User user) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(user);
    Response<User> response = servicePost.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param user user.
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody<User>>
      update(final @RequestBody @Valid User user, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    helper.setEntity(user);
    user.setId(id);
    Response<User> response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id   id.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody<User>> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response<User> response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param reportsRevenueFilter reportsRevenueFilter.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_USERS_RESERVED)
  public ResponseEntity<ResponseBody<User>> usersReserved(final @RequestBody @Valid DateFilter dateFilter) {
    Response<User> response = serviceGetFilterUsers.getResponse(dateFilter);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
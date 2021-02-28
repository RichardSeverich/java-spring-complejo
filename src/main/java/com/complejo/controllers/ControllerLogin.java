package com.complejo.controllers;

import com.complejo.helpers.Helper;
import com.complejo.models.UserAuth;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBody;
import com.complejo.services.ServiceLogin;
import com.complejo.support.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLogin {
  private static final String ENTITY_NAME = "userAuth";

  @Autowired
  private ServiceLogin serviceLogin;

  @Autowired
  private Helper<UserAuth> helper;

  /**
  * @param userAuth userAuth.
  * @return Response Entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_LOGIN)
  public ResponseEntity<ResponseBody> login(final @RequestBody @Valid UserAuth userAuth) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(userAuth);
    Response response = serviceLogin.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
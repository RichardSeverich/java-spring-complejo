package com.complejo.services;

import com.complejo.helpers.Helper;
import com.complejo.models.User;
import com.complejo.models.UserAuth;
import com.complejo.repository.RepositoryUsers;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import com.complejo.security.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServiceLogin implements IService {

  @Autowired
  private Helper<UserAuth> helper;

  @Autowired
  private ResponseBuilder<UserAuth> responseBuilder;

  @Autowired
  private RepositoryUsers repositoryUsers;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    String username = helper.getEntity().getUsername();
    String password = helper.getEntity().getPassword();
    Iterable<User> iterable = repositoryUsers.findUsers(username, password);
    boolean isEmpty = iterable.iterator().hasNext();
    // Negative scenario
    if (!isEmpty) {
      return responseBuilder.getResponseNotFound();
    }
    // Positive scenario
    helper.getEntity().setToken(JWTToken.getJWTToken(username));
    helper.getList().add(helper.getEntity());
    return responseBuilder.getResponseOkForGet();
  }
}

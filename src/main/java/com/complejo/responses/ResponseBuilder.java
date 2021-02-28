package com.complejo.responses;

import com.complejo.helpers.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
* Response Builder.
*/
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ResponseBuilder<T> {

  @Autowired
  private Helper<T> helper;

  private String entityName;

  private Response<T> response;

  private String message;

  /**
  * Constructor.
  */
  public  ResponseBuilder() {
    this.response = new Response<>();
    this.message = "";
    this.entityName = "";
  }

  /**
  * Build Body.
  */
  private void buildBody() {
    this.response.getBody().setMessage(this.message);
    this.response.getBody().setData(helper.getList());
  }

  /**
  * @return responses.
  */
  public Response<T> getResponseOkForGet() {
    this.entityName = helper.getEntityName();
    this.response.setHttpStatus(HttpStatus.OK);
    this.message = ResponseMessage.getSuccessfully(entityName);
    this.buildBody();
    return response;
  }

  /**
  * @return responses.
  */
  public Response<T> getResponseOkForPost() {
    this.entityName = helper.getEntityName();
    this.response.setHttpStatus(HttpStatus.CREATED);
    this.message = ResponseMessage.createdSuccessfully(entityName);
    this.buildBody();
    return response;
  }

  /**
  * @return responses.
  */
  public Response<T> getResponseOkForPut() {
    this.entityName = helper.getEntityName();
    this.response.setHttpStatus(HttpStatus.OK);
    this.message = ResponseMessage.updatedSuccessfully(entityName);
    this.buildBody();
    return response;
  }

  /**
  * @return responses.
  */
  public Response<T> getResponseOkForDelete() {
    this.entityName = helper.getEntityName();
    this.response.setHttpStatus(HttpStatus.OK);
    this.message = ResponseMessage.deletedSuccessfully(entityName);
    this.buildBody();
    return response;
  }

  /**
  * @return responses.
  */
  public Response<T> getResponseConflict() {
    this.entityName = helper.getEntityName();
    this.response.setHttpStatus(HttpStatus.CONFLICT);
    this.message = ResponseMessage.entityAlreadyExist(entityName);
    this.buildBody();
    return response;
  }

  /**
  * @return responses.
  */
  public Response<T> getResponseNotFound() {
    this.entityName = helper.getEntityName();
    this.response.setHttpStatus(HttpStatus.NOT_FOUND);
    this.message = ResponseMessage.entityNotFound(entityName);
    this.buildBody();
    return response;
  }

  /**
  * @return responses.
  */
  public Response<T> getResponseDataAccessException() {
    this.response.setHttpStatus(HttpStatus.CONFLICT);
    this.message = helper.getDataAccessException();
    this.buildBody();
    return this.response;
  }
}

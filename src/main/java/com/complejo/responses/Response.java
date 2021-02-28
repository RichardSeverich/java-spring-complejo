package com.complejo.responses;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;

/**
* @param <T> Response.
*/
public class Response<T> {

  @Getter @Setter
  private HttpStatus httpStatus;
  @Getter @Setter
  private ResponseBody<T> body;

  /**
  * Constructor.
  */
  public Response() {
    body = new ResponseBody<>();
  }
}

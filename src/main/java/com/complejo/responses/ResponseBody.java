package com.complejo.responses;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
*
* @param <T> ResponseBody.
*/
public class ResponseBody<T> {

  @Getter @Setter
  private String message;
  @Getter @Setter
  private List<T> data;

  /**
  * Constructor.
  */
  public ResponseBody() {
  }
}

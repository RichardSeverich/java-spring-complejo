package com.complejo.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
public class UserAuth {

  @NotNull
  @Size(min = 3, max = 10)
  @Getter @Setter
  private String username;

  @NotNull
  @Size(min = 3, max = 10)
  @Getter @Setter
  private String password;

  @Getter @Setter
  private String token;

  /**
  * Constructor.
  */
  public UserAuth() {
  }
}

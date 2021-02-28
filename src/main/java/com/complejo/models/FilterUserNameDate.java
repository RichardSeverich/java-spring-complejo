package com.complejo.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
public class FilterUserNameDate {

  @NotNull
  @Size(min = 3, max = 10)
  @Getter @Setter
  private String UserName;

  @NotNull
  @Size(min = 10, max = 10)
  @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
  @Getter @Setter
  private String bookingDate;

  /**
  * Constructor.
  */
  public FilterUserNameDate() {
  }
}

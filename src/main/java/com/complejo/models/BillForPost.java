package com.complejo.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
@Entity
@Table(name = "bills")
public class BillForPost  extends BillFather {

  @NotNull
  @Column(insertable = false, updatable = false)
  @Getter @Setter
  private ArrayList<BookingsResourcesJoin> arrayBookings;

  /**
  * Constructor.
  */
  public BillForPost() {
  }
}

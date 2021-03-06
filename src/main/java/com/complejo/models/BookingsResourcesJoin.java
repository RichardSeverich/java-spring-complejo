package com.complejo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
@Entity
public class BookingsResourcesJoin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter @Setter
  private Integer id;

  @Column(name = "comments")
  @Getter @Setter
  private String comments;

  @Column(name = "resource_name")
  @Getter @Setter
  private String resourceName;

  @Column(name = "price_hour")
  @Getter @Setter
  private String priceHour;

  @Column(name = "hours_interval_name")
  @Getter @Setter
  private String hoursIntervalName;

  @Column(name = "creation_date", insertable = false, updatable = false)
  @Getter @Setter
  private String creationDate;

  @Column(name = "update_date", insertable = false, updatable = false)
  @Getter @Setter
  private String updateDate;

  @Column(name = "created_by", updatable = false)
  @Getter @Setter
  private String createdBy;

  @Column(name = "updated_by", insertable = false)
  @Getter @Setter
  private String updatedBy;

  /**
  * Constructor.
  */
  public BookingsResourcesJoin() {
  }
}

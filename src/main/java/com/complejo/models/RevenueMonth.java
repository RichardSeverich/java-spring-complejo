package com.complejo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class RevenueMonth {

  @Id
  @Getter @Setter
  private Integer id;
  
  @Column(name = "month")
  @Getter @Setter
  private String month;

  @Column(name = "revenue")
  @Getter @Setter
  private String revenue;

  public RevenueMonth() {
  }
}

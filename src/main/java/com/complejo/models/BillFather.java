package com.complejo.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
@MappedSuperclass
public class BillFather {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter @Setter
  protected Integer id;

  @NotNull
  @Size(min = 10, max = 10)
  @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
  @Column(name = "bills_date")
  @Getter @Setter
  protected String billsDate;

  @NotNull
  @Size(min = 10, max = 10)
  @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
  @Column(name = "bills_date_limit")
  @Getter @Setter
  protected String billsDateLimit;

  @NotNull
  @Column(name = "bills_control_code")
  @Getter @Setter
  protected String billsControlCode;

  @NotNull
  @Size(min = 10, max = 10)
  @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
  @Column(name = "booking_date")
  @Getter @Setter
  protected String bookingDate;

  @NotNull
  @Column(name = "company_name")
  @Getter @Setter
  protected String companyName;

  @NotNull
  @Column(name = "company_nit")
  @Getter @Setter
  protected String companyNit;

  @NotNull
  @Column(name = "company_authorization")
  @Getter @Setter
  protected String companyAuthorization;

  @NotNull
  @Column(name = "client_name")
  @Getter @Setter
  protected String clientName;

  @NotNull
  @Column(name = "client_nit")
  @Getter @Setter
  protected String clientNit;

  @Column(name = "creation_date", insertable = false, updatable = false)
  @Getter @Setter
  protected String creationDate;

  @Column(name = "update_date", insertable = false, updatable = false)
  @Getter @Setter
  protected String updateDate;

  @Column(name = "created_by", updatable = false)
  @Getter @Setter
  protected String createdBy;

  @Column(name = "updated_by", insertable = false)
  @Getter @Setter
  protected String updatedBy;

  /**
  * Constructor.
  */
  public BillFather() {
  }
}

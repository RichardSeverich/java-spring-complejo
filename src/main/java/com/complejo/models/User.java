package com.complejo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter @Setter
  private Integer id;

  @NotNull
  @Size(min = 3, max = 10)
  @Column(name = "username")
  @Getter @Setter
  private String username;

  @NotNull
  @Size(min = 3, max = 10)
  @Column(name = "password")
  @Getter @Setter
  private String password;

  @NotNull
  @Size(min = 4, max = 10)
  @Column(name = "dni")
  @Getter @Setter
  private String dni;

  @NotNull
  @Size(min = 4, max = 50)
  @Column(name = "name")
  @Getter @Setter
  private String name;

  @NotNull
  @Size(min = 4, max = 50)
  @Column(name = "father_last_name")
  @Getter @Setter
  private String fatherLastName;

  @NotNull
  @Size(min = 4, max = 50)
  @Column(name = "mother_last_name")
  @Getter @Setter
  private String motherLastName;

  @NotNull
  @Size(min = 10, max = 10)
  @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
  @Column(name = "birth_date")
  @Getter @Setter
  private String birthDate;

  @NotNull
  @Size(min = 3, max = 30)
  @Column(name = "telephone")
  @Getter @Setter
  private String telephone;

  @NotNull
  @Size(min = 3, max = 30)
  @Column(name = "address")
  @Getter @Setter
  private String address;

  @NotNull
  @Size(min = 7, max = 30)
  @Pattern(regexp = "^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$")
  @Column(name = "email")
  @Getter @Setter
  private String email;

  @NotNull
  @Size(min = 5, max = 10)
  @Pattern(regexp = "(admin|instructor)")
  @Column(name = "type")
  @Getter @Setter
  private String type;

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
  public User() {
  }
}

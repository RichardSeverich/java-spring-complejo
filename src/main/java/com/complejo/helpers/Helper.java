package com.complejo.helpers;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


/**
* Helper Class.
*/
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Helper<T> {

  @Getter @Setter
  private String entityName;
  @Getter @Setter
  private Integer id;
  @Getter @Setter
  private Integer idAux;
  @Getter @Setter
  private T entity;
  @Getter @Setter
  private List<T> list;
  @Getter @Setter
  private String dataAccessException;

  /**
  * Constructor.
  */
  public Helper() {
    this.id = 0;
    this.idAux = 0;
    this.list = new ArrayList<>();
    this.entityName = "";
  }
}

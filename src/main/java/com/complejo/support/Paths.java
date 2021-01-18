package com.complejo.support;

/**
* Constants Paths utility class.
*/
public final class Paths {
  private static final String VERSION = "/api/v1";
  private static final String LOGIN = "/login";
  private static final String USER = "/users";
  private static final String RESOURCE = "/resources";
  private static final String ID = "/{id}";
  // Login
  public static final String PATH_LOGIN = VERSION + LOGIN;
  // Users
  public static final String PATH_USERS = VERSION + USER;
  public static final String PATH_USERS_WITH_ID = PATH_USERS + ID;
  // Resources
  public static final String PATH_RESOURCES = VERSION + RESOURCE;
  public static final String PATH_RESOURCES_WITH_ID = PATH_RESOURCES + ID;

  /**
  * Private constructor for utility class.
  */
  private Paths() {
  }
}

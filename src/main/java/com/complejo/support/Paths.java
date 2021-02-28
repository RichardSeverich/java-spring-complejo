package com.complejo.support;

/**
* Constants Paths utility class.
*/
public final class Paths {
  private static final String VERSION = "/api/v1";
  private static final String LOGIN = "/login";
  private static final String USER = "/users";
  private static final String USER_RESERVED = "/filter-who-reserved";
  private static final String RESOURCE = "/resources";
  private static final String BOOKING = "/bookings";
  private static final String HOURS_INTERVAL = "/hours-interval";
  private static final String BILLS = "/bills";
  private static final String DETAIL = "/detail";
  private static final String BILLS_DETAIL = "/bills-detail";
  private static final String BILLS_FILTER_DATE = "/filter-date";
  private static final String AVALIABLE_HOURS = "/filter-avaliable";
  private static final String RESERVED_HOURS = "/filter-reserved";
  private static final String REPORTS_REVENUE = "/reports-revenue";
  private static final String RESERVED_RESOURCES = "/reserved-resources";
  private static final String ID = "/{id}";
  // Login
  public static final String PATH_LOGIN = VERSION + LOGIN;
  // Users
  public static final String PATH_USERS = VERSION + USER;
  public static final String PATH_USERS_WITH_ID = PATH_USERS + ID;
  // Resources
  public static final String PATH_RESOURCES = VERSION + RESOURCE;
  public static final String PATH_RESOURCES_WITH_ID = PATH_RESOURCES + ID;
  // Bookings
  public static final String PATH_BOOKINGS = VERSION + BOOKING;
  public static final String PATH_BOOKINGS_WITH_ID = PATH_BOOKINGS + ID;
  // Hours Intervals
  public static final String PATH_HOURS_INTERVALS = VERSION + HOURS_INTERVAL;
  public static final String PATH_HOURS_INTERVALS_WITH_ID = PATH_HOURS_INTERVALS + ID;
  // Bills
  public static final String PATH_BILLS = VERSION + BILLS;
  public static final String PATH_BILLS_WITH_ID = PATH_BILLS + ID;
  // Bills Detail
  public static final String PATH_BILLS_DETAIL = VERSION + BILLS_DETAIL;
  public static final String PATH_BILLS_DETAIL_WITH_ID = PATH_BILLS_DETAIL + ID;
  // Avaliable Hours
  public static final String PATH_AVALIABLE_HOURS = PATH_HOURS_INTERVALS + AVALIABLE_HOURS;
  // Reserved Hours
  public static final String PATH_RESERVED_HOURS = PATH_HOURS_INTERVALS + RESERVED_HOURS;
  // Reports Revenue
  public static final String PATH_REPORTS_REVENUE = VERSION + REPORTS_REVENUE;
  // Reserved Resources
  public static final String PATH_RESERVED_RESOURCES = VERSION + RESERVED_RESOURCES;
  // Users Reserved
  public static final String PATH_USERS_RESERVED = PATH_USERS + USER_RESERVED;
  // Bills Filter Date
  public static final String PATH_BILLS_FILTER_DATE = PATH_BILLS + BILLS_FILTER_DATE;
  // Bills Detail
  public static final String PATH_DETAIL = PATH_BILLS + DETAIL;

  /**
  * Private constructor for utility class.
  */
  private Paths() {
  }
}

package com.complejo.responses;

/**
* Class.
*/
public final class ResponseMessage {

  /**
  * Constructor.
  */
  private ResponseMessage() {
  }

  /**
  * @param entity entity.
  * @return Message.
  */
  public static String getSuccessfully(final String entity) {
    return String.format("The get %s successfully", entity);
  }

  /**
  * @param entity entity.
  * @return Message.
  */
  public static String createdSuccessfully(final String entity) {
    return String.format("The %s was created successfully", entity);
  }

  /**
  * @param entity entity.
  * @return Message.
  */
  public static String updatedSuccessfully(final String entity) {
    return String.format("The %s was updated successfully", entity);
  }

  /**
  * @param entity entity.
  * @return Message.
  */
  public static String deletedSuccessfully(final String entity) {
    return String.format("The %s was deleted successfully", entity);
  }

  /**
  * @param entity entity.
  * @return Message.
  */
  public static String entityAlreadyExist(final String entity) {
    return String.format("The %s already exist", entity);
  }

  /**
  * @param entity entity.
  * @return Message.
  */
  public static String entityNotFound(final String entity) {
    return String.format("The %s does not exist", entity);
  }

  /**
  * @param entity entity.
  * @return Message.
  */
  public static String entityHasRelation(final String entity) {
    return String.format("The %s has relation, request cannot be applied", entity);
  }
}

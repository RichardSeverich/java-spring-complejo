package com.complejo.services;

import com.complejo.helpers.Helper;
import com.complejo.repository.RepositoryFactory;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServicePost<T> implements IService {

  @Autowired
  private Helper<T> helper;

  @Autowired
  private ResponseBuilder<T> responseBuilder;

  @Autowired
  private RepositoryFactory repositoryFactory;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    JpaRepository repository = repositoryFactory.getRepository(helper.getEntityName());
    // Positive scenario
    T entity = helper.getEntity();
    helper.getList().add(entity);
    try {
      repository.save(entity);
      return responseBuilder.getResponseOkForPost();
    } catch (DataAccessException ex) {
      helper.setDataAccessException(ex.getMostSpecificCause().getMessage());
      //System.out.println(ex.getLocalizedMessage());
      //System.out.println(ex.getMostSpecificCause());
      return responseBuilder.getResponseDataAccessException();
    }
  }
}

package com.complejo.services;

import com.complejo.helpers.Helper;
import com.complejo.repository.RepositoryFactory;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServiceGetById<T> implements IService {

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
    T entity = (T) repository.findById(helper.getId()).orElse(null);
    // Negative scenario
    if (entity == null) {
      return responseBuilder.getResponseNotFound();
    }
    // Positive scenario
    helper.getList().add(entity);
    return responseBuilder.getResponseOkForGet();
  }
}

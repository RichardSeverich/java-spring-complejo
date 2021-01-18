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
public class ServiceGet<T> implements IService {

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
    Iterable<T> iterable = repository.findAll();
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}

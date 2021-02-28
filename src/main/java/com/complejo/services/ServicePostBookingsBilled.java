package com.complejo.services;

import com.complejo.models.BillForPost;
import com.complejo.models.BillsDetail;
import com.complejo.models.BookingsResourcesJoin;
import com.complejo.helpers.Helper;
import com.complejo.repository.RepositoryBillsDetail;
import com.complejo.repository.RepositoryBookings;
import com.complejo.repository.RepositoryFactory;
import com.complejo.responses.Response;
import com.complejo.responses.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

/**
* Service.
*/
@Service
public class ServicePostBookingsBilled {

  @Autowired
  private RepositoryBookings repositoryBookings;

  @Autowired
  private RepositoryBillsDetail repositoryBillsDetail;

  /**
  * @param servicePost servicePost.
  * @param bill bill.
  * @return Response Entity.
  */
  @SuppressWarnings("unchecked")
  public Response<BillForPost> getResponse(ServicePost<BillForPost> servicePost, BillForPost bill) {
    Response<BillForPost> response = servicePost.getResponse();
    if(response.getHttpStatus() == HttpStatus.CREATED) {
      for(BookingsResourcesJoin itemBooking : bill.getArrayBookings()){
        int idBooking = itemBooking.getId();
        repositoryBookings.updateBilled(idBooking);
        BillForPost newBill = (BillForPost)response.getBody().getData().get(0);
        repositoryBillsDetail.insertBillDetails(idBooking, 
            newBill.getId(), bill.getCreatedBy());
      }
    }
    return response;
  }
}

package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.ResponseToTicket;

public interface ResponseToTicketRepository extends JpaRepository<ResponseToTicket, Integer>, JpaSpecificationExecutor<ResponseToTicket> {

}
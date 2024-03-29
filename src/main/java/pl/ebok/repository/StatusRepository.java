package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>, JpaSpecificationExecutor<Status> {

}
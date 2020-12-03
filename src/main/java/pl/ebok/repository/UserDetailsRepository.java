package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>, JpaSpecificationExecutor<UserDetails> {

}
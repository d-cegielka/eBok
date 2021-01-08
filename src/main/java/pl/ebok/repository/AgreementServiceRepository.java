package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.AgreementService;

public interface AgreementServiceRepository extends JpaRepository<AgreementService, Integer>, JpaSpecificationExecutor<AgreementService> {

}
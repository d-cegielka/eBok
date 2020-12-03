package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.Agreement;

public interface AgreementRepository extends JpaRepository<Agreement, Integer>, JpaSpecificationExecutor<Agreement> {

}
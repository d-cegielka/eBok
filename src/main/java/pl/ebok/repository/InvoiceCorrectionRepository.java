package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.InvoiceCorrection;

public interface InvoiceCorrectionRepository extends JpaRepository<InvoiceCorrection, Integer>, JpaSpecificationExecutor<InvoiceCorrection> {

}
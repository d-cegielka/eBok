package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.Hardware;

public interface HardwareRepository extends JpaRepository<Hardware, Integer>, JpaSpecificationExecutor<Hardware> {

}
package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.Permission;

public interface PrivilegeRepository extends JpaRepository<Permission, Integer>, JpaSpecificationExecutor<Permission> {

}
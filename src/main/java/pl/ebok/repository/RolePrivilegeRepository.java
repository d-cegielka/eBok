package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.ebok.model.RolePrivilege;

public interface RolePrivilegeRepository extends JpaRepository<RolePrivilege, Integer>, JpaSpecificationExecutor<RolePrivilege> {

}
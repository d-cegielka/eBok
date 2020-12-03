package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import pl.ebok.model.User;

import javax.persistence.StoredProcedureQuery;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @Procedure(name = "User.addUser")
    String addUser(@Param("firstName") String firstName,
                 @Param("lastName") String lastName,
                 @Param("email") String email,
                 @Param("password") String password,
                 @Param("enabledAccount") Boolean enabledAccount,
                 @Param("idRole") Integer idRole,
                 @Param("responseMessage") String responseMessage);

    /*String addUser(String firstName, String lastName, String email, String password,
                          Boolean enabledAccount, Integer idRole);*/
}
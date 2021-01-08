package pl.ebok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import pl.ebok.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
/*    @Procedure(name = "User.addUser")
    String addUser(@Param("firstName") String firstName,
                 @Param("lastName") String lastName,
                 @Param("email") String email,
                 @Param("password") String password,
                 @Param("enabledAccount") Boolean enabledAccount,
                 @Param("businessAccount") Boolean businessAccount,
                 @Param("companyName") String companyName,
                 @Param("taxId") String taxId,
                 @Param("phoneNumber") String phoneNumber,
                 @Param("address") String address,
                 @Param("")
                 @Param("responseMessage") String responseMessage);
    */
    @Procedure(name = "User.addUser")
    String addUser(String firstName, String lastName, String email, String password,
                          Boolean enabledAccount, Boolean businessAccount, String companyName,  String taxId,
                   String phoneNumber,  String address, String zipCode, String city, String responseMessage);
}


/*
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "companyName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "taxId", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "phoneNumber", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "address", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "zipCode", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "city", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "responseMessage", type = String.class),
 */
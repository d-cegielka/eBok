package pl.ebok.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.repository.UserRepository;

import javax.persistence.*;
import java.util.List;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@RestController
public class UsersManager {
    private final UserRepository userRepository;
/*
    @Autowired
    private EntityManager entityManager;
*/

    @Autowired
    public UsersManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public String addUser(String firstName, String lastName, String email, String password,
                          Boolean enabledAccount, Integer idRole) {
        StoredProcedureQuery sp = this.entityManager.createNamedStoredProcedureQuery("User.addUser");

        sp.registerStoredProcedureParameter("firstName",String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("lastName",String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("email",String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("password",String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("enabledAccount",Boolean.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("idRole",Integer.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("responseMessage",String.class, ParameterMode.INOUT);
        sp.setParameter("firstName", firstName);
        sp.setParameter("lastName", lastName);
        sp.setParameter("email", email);
        sp.setParameter("password", password);
        sp.setParameter("enabledAccount",enabledAccount);
        sp.setParameter("idRole",idRole);
        sp.setParameter("responseMessage","");

        sp.execute();
        List s = sp.getResultList();
        System.out.println(s.get(0));
        return sp.getOutputParameterValue("responseMessage").toString();
    }*/

    @RequestMapping("/getUsers")
    @ResponseBody
    public String getUsers(){
        String message = userRepository.addUser("Jan","DANA",
                "dc@dc.com","1234",true,1,"");
        System.out.println("Message: " + message);
        return message;
    }


}

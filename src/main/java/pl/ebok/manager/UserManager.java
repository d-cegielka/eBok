package pl.ebok.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.IUser;
import pl.ebok.model.User;
import pl.ebok.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@RestController
public class UserManager implements IUser {
    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
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

   /* @RequestMapping("/getUsers")
    @ResponseBody
    public String getUsers(){
        String message = userRepository.addUser("Jan","DANA",
                "dc@dc.com","12345678",true,1,"");
        System.out.println("Message: " + message);
        return message;
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public String getAllUsers(){
        return userRepository.findAll().toString();
    }*/


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public String addUser(User user) {
        return userRepository.addUser(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPasswordHash(),user.getEnabledAccount(), user.getBusinessAccount(), user.getCompanyName(), user.getTaxId(), user.getPhoneNumber(), user.getAddress(), user.getZipCode(),user.getCity(), "");
    }

    @Override
    public String deleteUser(Integer id) {
        return null;
    }
}

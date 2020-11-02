package pl.ebok.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.model.User;
import pl.ebok.repository.UsersRepository;

@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@RestController
public class UsersManager {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersManager(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public String getUsers(){
        User user = new User();
        user.setFirstname("Jan");
        user.setLastname("Kowalski");
        user.setEmail("dc@gmail.com");
        user.setEnabled(true);

        usersRepository.save(user);

        return usersRepository.findAll().toString();
    }


}

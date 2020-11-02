package pl.ebok.repository;

import org.springframework.data.repository.CrudRepository;
import pl.ebok.model.User;

public interface UsersRepository extends CrudRepository<User, Integer> {

}


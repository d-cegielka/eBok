package pl.ebok;

import org.springframework.web.bind.annotation.*;
import pl.ebok.model.User;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
public interface IUser {

    @GetMapping("/")
    List<User> getAll();

    @GetMapping("/{id}")
    Optional<User> getById(@PathVariable Integer id);

    @PostMapping("/")
    String addUser(@RequestBody User user);

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Integer id);
}

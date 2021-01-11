package pl.ebok;

import org.springframework.web.bind.annotation.*;
import pl.ebok.model.Agreement;
import pl.ebok.model.Hardware;
import pl.ebok.model.Service;

import java.util.List;
import java.util.Optional;

@RequestMapping("/services")
public interface IService {

    @GetMapping("/")
    List<Service> getAll();

    @GetMapping("/{id}")
    Optional<Service> getById(@PathVariable Integer id);

    @PostMapping("/")
    Service addService(@RequestBody Service hardware);

    @PutMapping("/{id}")
    Service updateService(@RequestBody Service changedService, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    void deleteService(@PathVariable Integer id);
}

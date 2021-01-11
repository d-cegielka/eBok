package pl.ebok;

import org.springframework.web.bind.annotation.*;
import pl.ebok.model.Hardware;
import java.util.List;
import java.util.Optional;

@RequestMapping("/hardwares")
public interface IHardware {

    @GetMapping("/")
    List<Hardware> getAll();

    @GetMapping("/{id}")
    Optional<Hardware> getById(@PathVariable Integer id);

    @PostMapping("/")
    Hardware addHardware(@RequestBody Hardware hardware);

    @PutMapping("/{id}")
    Hardware updateHardware(@RequestBody Hardware changedHardware, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    void deleteHardware(@PathVariable Integer id);
}

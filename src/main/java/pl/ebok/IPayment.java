package pl.ebok;

import org.springframework.web.bind.annotation.*;
import pl.ebok.model.Payment;
import pl.ebok.model.Service;

import java.util.List;
import java.util.Optional;

@RequestMapping("/payments")
public interface IPayment {

    @GetMapping("/")
    List<Payment> getAll();

    @GetMapping("/{id}")
    Optional<Payment> getById(@PathVariable Integer id);

    @PostMapping("/")
    Payment addPayment(@RequestBody Payment hardware);

    @PutMapping("/{id}")
    Payment updatePayment(@RequestBody Payment changedPayment, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    void deletePayment(@PathVariable Integer id);
}

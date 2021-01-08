package pl.ebok;

import org.springframework.web.bind.annotation.*;
import pl.ebok.model.Agreement;
import pl.ebok.model.AgreementService;
import pl.ebok.model.Hardware;

import java.util.List;
import java.util.Optional;

@RequestMapping("/agreements")
public interface IAgreement {

    @GetMapping("/")
    List<Agreement> getAll();

    @GetMapping("/{id}")
    Optional<Agreement> getById(@PathVariable Integer id);

    @PostMapping("/")
    Agreement addAgreement(@RequestBody Agreement agreement, @RequestBody List<AgreementService> agreementServices, @RequestBody List<Hardware> hardwares);

    @PutMapping("/{id}")
    Agreement updateAgreement(@RequestBody Agreement changedAgreement, @PathVariable Integer id);
}

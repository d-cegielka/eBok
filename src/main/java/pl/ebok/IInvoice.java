package pl.ebok;

import org.springframework.web.bind.annotation.*;
import pl.ebok.model.Invoice;
import pl.ebok.model.InvoiceCorrection;

import java.util.List;
import java.util.Optional;

@RequestMapping("/invoices")
public interface IInvoice {

    @GetMapping("/")
    List<Invoice> getAll();

    @GetMapping("/corrections")
    List<InvoiceCorrection> getAllCorrections();

    @GetMapping("/{id}")
    Optional<Invoice> getById(@PathVariable Integer id);

    @GetMapping("/{id_invoice}/corrections")
    List<InvoiceCorrection> getCorrectionsByInvoiceId(@PathVariable Integer id_invoice);

    @PostMapping("/")
    Invoice addInvoice(@RequestBody Invoice invoice);

    @PostMapping("/{id_invoice}/")
    Invoice addInvoiceCorrection(@RequestBody InvoiceCorrection invoiceCorrection, @PathVariable Integer id_invoice);

}

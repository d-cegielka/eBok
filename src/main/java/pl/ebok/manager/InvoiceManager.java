package pl.ebok.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.IInvoice;
import pl.ebok.model.Invoice;
import pl.ebok.model.InvoiceCorrection;
import pl.ebok.repository.InvoiceCorrectionRepository;
import pl.ebok.repository.InvoiceRepository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackageClasses = {InvoiceRepository.class, InvoiceCorrection.class})
@RestController
public class InvoiceManager implements IInvoice {
    final InvoiceRepository invoiceRepository;
    final InvoiceCorrectionRepository invoiceCorrectionRepository;

    @Autowired
    public InvoiceManager(InvoiceRepository invoiceRepository, InvoiceCorrectionRepository invoiceCorrectionRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceCorrectionRepository = invoiceCorrectionRepository;
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<InvoiceCorrection> getAllCorrections() {
        return invoiceCorrectionRepository.findAll();
    }

    @Override
    public Optional<Invoice> getById(Integer id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public List<InvoiceCorrection> getCorrectionsByInvoiceId(Integer id_invoice) {
        Optional<Invoice> invoice = invoiceRepository.findById(id_invoice);
        if (invoice.isEmpty())
            return null;

        return invoice.get().getInvoicesCorrection();
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceCorrection addInvoiceCorrection(InvoiceCorrection invoiceCorrection) {
        return invoiceCorrectionRepository.save(invoiceCorrection);
    }
}

package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice", nullable = false)
    private Integer idInvoice;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "id_expositor", nullable = false)
    private User expositor;

    @ManyToOne
    @JoinColumn(name = "id_agreement", nullable = false)
    private Agreement agreement;

    @Column(name = "invoice_number", length = 50, nullable = false)
    private String invoiceNumber;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceCorrection> invoicesCorrection;

    @OneToMany(mappedBy = "invoice")
    private Set<Payment> payments;

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User idClient) {
        this.client = idClient;
    }

    public User getExpositor() {
        return expositor;
    }

    public void setExpositor(User idExpositor) {
        this.expositor = idExpositor;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement idAgreement) {
        this.agreement = idAgreement;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

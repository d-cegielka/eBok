package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "invoice_correction")
public class InvoiceCorrection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice_correction", nullable = false)
    private Integer idInvoiceCorrection;

    @ManyToOne
    @JoinColumn(name = "id_invoice", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "id_expositor", nullable = false)
    private User expositor;

    @Column(name = "invoice_correction_number", length = 50, nullable = false)
    private String invoiceCorrectionNumber;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    public InvoiceCorrection setIdInvoiceCorrection(Integer idInvoiceCorrection) {
        this.idInvoiceCorrection = idInvoiceCorrection;
        return this;
    }

    public Integer getIdInvoiceCorrection() {
        return idInvoiceCorrection;
    }

    public InvoiceCorrection setInvoice(Invoice idInvoice) {
        this.invoice = idInvoice;
        return this;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public InvoiceCorrection setExpositor(User idExpositor) {
        this.expositor = idExpositor;
        return this;
    }

    public User getExpositor() {
        return expositor;
    }

    public InvoiceCorrection setInvoiceCorrectionNumber(String invoiceCorrectionNumber) {
        this.invoiceCorrectionNumber = invoiceCorrectionNumber;
        return this;
    }

    public String getInvoiceCorrectionNumber() {
        return invoiceCorrectionNumber;
    }

    public InvoiceCorrection setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public InvoiceCorrection setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public InvoiceCorrection setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "InvoiceCorrection{" +
                "idInvoiceCorrection=" + idInvoiceCorrection + '\'' +
                "idInvoice=" + invoice + '\'' +
                "idExpositor=" + expositor + '\'' +
                "invoiceCorrectionNumber=" + invoiceCorrectionNumber + '\'' +
                "issueDate=" + issueDate + '\'' +
                "paymentDate=" + paymentDate + '\'' +
                "amount=" + amount + '\'' +
                '}';
    }
}

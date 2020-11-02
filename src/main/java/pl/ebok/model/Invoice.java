package pl.ebok.model;

import javax.persistence.*;

@Entity
public class Invoice {
    @GeneratedValue
    @Id
    private Integer invoiceId;

    @ManyToOne
    private User client;

    @ManyToOne
    private User expositor;

    @ManyToOne
    private Agreement agreement;

    @Column
    private String invoiceNumber;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getExpositor() {
        return expositor;
    }

    public void setExpositor(User expositor) {
        this.expositor = expositor;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}

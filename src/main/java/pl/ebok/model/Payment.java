package pl.ebok.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @GeneratedValue
    @Id
    private Integer paymentId;

    @ManyToOne
    private User client;

    @ManyToOne
    private Invoice invoice;

    @Column
    private LocalDateTime paymentDate;

    @Column
    private Double amount;

    @Column
    private String status;

    public Integer getPaymentId() {
        return paymentId;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

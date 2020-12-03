package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment", nullable = false)
    private Integer idPayment;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "id_invoice", nullable = false)
    private Invoice invoice;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User idClient) {
        this.client = idClient;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice idInvoice) {
        this.invoice = idInvoice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

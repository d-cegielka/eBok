package pl.ebok.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

@Entity
public class Agreement {
    @GeneratedValue
    @Id
    private int agreementId;
    @ManyToMany(mappedBy = "agreements")
    private List<Hardware> hardwares;
    @Column
    private LocalDate creationDate;
    @Column
    private LocalDate dateSigned;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @Column
    private MonthDay billingDay;
    @ManyToOne
    private User user;

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }

    public List<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(List<Hardware> hardwares) {
        this.hardwares = hardwares;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(LocalDate dateSigned) {
        this.dateSigned = dateSigned;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public MonthDay getBillingDay() {
        return billingDay;
    }

    public void setBillingDay(MonthDay billingDay) {
        this.billingDay = billingDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

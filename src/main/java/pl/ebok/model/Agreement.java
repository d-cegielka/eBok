package pl.ebok.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "agreement")
public class Agreement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agreement", nullable = false)
    private Integer idAgreement;

    @Column(name = "agreement_type", length = 10, nullable = false)
    private String agreementType;

    @Column(name = "agreement_number", length = 25, nullable = false)
    private String agreementNumber;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "date_signed")
    private LocalDate dateSigned;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "billing_day", nullable = false)
    private Integer billingDay;

    @ManyToOne
    @JoinColumn(name="id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "agreement")
    private Set<Invoice> invoices;

    @ManyToMany
    @JoinTable(name = "agreement_hardware",
            joinColumns = @JoinColumn(name = "id_agreement", referencedColumnName = "id_agreement"),
            inverseJoinColumns = @JoinColumn(name = "id_hardware", referencedColumnName = "id_hardware"))
    private Set<Hardware> hardwares = new HashSet<>();

    @OneToMany(mappedBy = "agreement")
    private Set<AgreementService> agreementServices;
    /*@ManyToMany
    @JoinTable(name = "agreement_service",
            joinColumns = @JoinColumn(name = "id_agreement", referencedColumnName = "id_agreement"),
            inverseJoinColumns = @JoinColumn(name = "id_service", referencedColumnName = "id_service"))
    private Set<Service> services = new HashSet<>();*/

    public Agreement setIdAgreement(Integer idAgreement) {
        this.idAgreement = idAgreement;
        return this;
    }

    public Integer getIdAgreement() {
        return idAgreement;
    }

    public Agreement setAgreementType(String agreementType) {
        this.agreementType = agreementType;
        return this;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public Agreement setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
        return this;
    }

    public String getAgreementNumber() {
        return agreementNumber;
    }

    public Agreement setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Agreement setDateSigned(LocalDate dateSigned) {
        this.dateSigned = dateSigned;
        return this;
    }

    public LocalDate getDateSigned() {
        return dateSigned;
    }

    public Agreement setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Agreement setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Agreement setBillingDay(Integer billingDay) {
        this.billingDay = billingDay;
        return this;
    }

    public Integer getBillingDay() {
        return billingDay;
    }

    public User getUser() {
        return user;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public Set<Hardware> getHardwares() {
        return hardwares;
    }

    public Set<AgreementService> getAgreementServices() {
        return agreementServices;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "idAgreement=" + idAgreement + '\'' +
                "agreementType=" + agreementType + '\'' +
                "agreementNumber=" + agreementNumber + '\'' +
                "creationDate=" + creationDate + '\'' +
                "dateSigned=" + dateSigned + '\'' +
                "startDate=" + startDate + '\'' +
                "endDate=" + endDate + '\'' +
                "billingDay=" + billingDay + '\'' +
                '}';
    }
}

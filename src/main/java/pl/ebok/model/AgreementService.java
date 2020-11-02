package pl.ebok.model;

import javax.persistence.*;

@Entity
public class AgreementService {
    @GeneratedValue
    @Id
    private Integer id;

    @ManyToOne
    private Agreement agreement;

    @ManyToOne
    private Service service;

    @Column
    private Double finalFee;

    public Integer getId() {
        return id;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Double getFinalFee() {
        return finalFee;
    }

    public void setFinalFee(Double finalFee) {
        this.finalFee = finalFee;
    }
}

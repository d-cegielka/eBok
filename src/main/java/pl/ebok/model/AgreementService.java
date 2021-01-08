package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "agreement_service")
public class AgreementService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agreement_service", nullable = false)
    private Integer idAgreementService;

    @ManyToOne
    @JoinColumn(name = "id_agreement", nullable = false)
    private Agreement agreement;

    @ManyToOne
    @JoinColumn(name = "id_service", nullable = false)
    private Service service;

    @Column(name = "final_fee", nullable = false)
    private Double finalFee;

    public AgreementService setIdAgreementService(Integer idAgreementService) {
        this.idAgreementService = idAgreementService;
        return this;
    }

    public Integer getIdAgreementService() {
        return idAgreementService;
    }

    public AgreementService setAgreement(Agreement idAgreement) {
        this.agreement = idAgreement;
        return this;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public AgreementService setService(Service idService) {
        this.service = idService;
        return this;
    }

    public Service getService() {
        return service;
    }

    public AgreementService setFinalFee(Double finalFee) {
        this.finalFee = finalFee;
        return this;
    }

    public Double getFinalFee() {
        return finalFee;
    }

    @Override
    public String toString() {
        return "AgreementService{" +
                "idAgreementService=" + idAgreementService + '\'' +
                "idAgreement=" + agreement + '\'' +
                "idService=" + service + '\'' +
                "finalFee=" + finalFee + '\'' +
                '}';
    }
}

package pl.ebok.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service", nullable = false)
    private Integer idService;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "fee", nullable = false)
    private Double fee;

    @Column(name = "description", length = 300)
    private String description;

    public Service(String name, Double fee, String description) {
        this.name = name;
        this.fee = fee;
        this.description = description;
    }
/*@ManyToMany(mappedBy = "services")
    private Set<Agreement> agreements = new HashSet<>();*/

    @OneToMany(mappedBy = "service")
    private Set<AgreementService> agreementServices;

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getFee() {
        return fee;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService + '\'' +
                "name=" + name + '\'' +
                "fee=" + fee + '\'' +
                "description=" + description + '\'' +
                '}';
    }
}

package pl.ebok.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @GeneratedValue
    @Id
    private Integer serviceId;

    @Column
    private String name;

    @Column
    private Double fee;

    @Column
    @Lob
    private String description;

    @OneToMany(mappedBy = "service")
    private List<AgreementService> services;

    public Integer getServiceId() {
        return serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AgreementService> getServices() {
        return services;
    }

    public void setServices(List<AgreementService> services) {
        this.services = services;
    }
}

package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;

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

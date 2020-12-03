package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hardware")
public class Hardware implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hardware", nullable = false)
    private Integer idHardware;

    @Column(name = "type", length = 40, nullable = false)
    private String type;

    @Column(name = "manufacturer", length = 40, nullable = false)
    private String manufacturer;

    @Column(name = "model", length = 40, nullable = false)
    private String model;

    @Column(name = "serial_number", length = 40, unique = true, nullable = false)
    private String serialNumber;

    @Column(name = "fee", nullable = false)
    private Double fee;

    @ManyToMany(mappedBy = "hardwares")
    private Set<Agreement> agreements = new HashSet<>();

    public Integer getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(Integer idHardware) {
        this.idHardware = idHardware;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}

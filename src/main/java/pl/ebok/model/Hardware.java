package pl.ebok.model;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.List;

@Entity
public class Hardware {
    @GeneratedValue
    @Id
    private int hardwareId;
    @Column
    private String type;
    @Column
    private String manufacturer;
    @Column
    private String model;
    @Column
    private String serialNumber;
    @Column
    private Double fee;
    @ManyToMany
    private List<Agreement> agreements;

    public int getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(int hardwareId) {
        this.hardwareId = hardwareId;
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

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(List<Agreement> agreements) {
        this.agreements = agreements;
    }
}

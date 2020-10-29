package pl.ebok.model;

import javax.persistence.*;
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

}

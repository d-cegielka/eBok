package pl.ebok.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @GeneratedValue
    @Id
    private int serviceId;

    @Column
    private String name;

    @Column
    private Double fee;

    @Column
    @Lob
    private String description;

    @OneToMany(mappedBy = "service")
    private List<Service> services;

}

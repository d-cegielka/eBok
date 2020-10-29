package pl.ebok.model;

import javax.persistence.*;

@Entity
public class AgreementService {
    @GeneratedValue
    @Id
    private int id;

    @ManyToOne
    private Agreement agreement;

    @ManyToOne
    private Service service;

    @Column
    private Double finalFee;

}

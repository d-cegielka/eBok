package pl.ebok.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

@Entity
public class Agreement {
    @GeneratedValue
    @Id
    private int agreementId;

    @Column
    private LocalDate creationDate;

    @Column
    private LocalDate dateSigned;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private MonthDay billingDay;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "agreements")
    private List<Hardware> hardwares;

    @OneToMany(mappedBy = "agreement")
    private List<Service> services;

    @OneToMany(mappedBy = "agreement")
    private List<Invoice> invoices;


}

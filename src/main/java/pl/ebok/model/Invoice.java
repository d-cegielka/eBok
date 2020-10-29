package pl.ebok.model;

import javax.persistence.*;

@Entity
public class Invoice {
    @GeneratedValue
    @Id
    private int invoiceId;

    @ManyToOne
    private User client;

    @ManyToOne
    private User expositor;

    @ManyToOne
    private Agreement agreement;

    @Column
    private String invoiceNumber;
}

package pl.ebok.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {
    @GeneratedValue
    @Id
    private int userId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String pesel;

    @Column
    private LocalDate birthdayDate;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @ManyToOne
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoicesClients;

    @OneToMany(mappedBy = "expositor")
    private List<Invoice> invoicesExpositors;
}

package pl.ebok.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
@NamedStoredProcedureQuery(name = "User.addUser",
procedureName = "sp_add_user", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "firstName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "lastName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "enabledAccount", type = Boolean.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "idRole", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "responseMessage", type = String.class),
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "enabled_account", nullable = false)
    private Boolean enabledAccount;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "client")
    private Set<Invoice> invoicesClient;

    @OneToMany(mappedBy = "expositor")
    private Set<Invoice> invoicesExpositor;

    @OneToMany(mappedBy = "user")
    private Set<Agreement> agreements;

    @OneToMany(mappedBy = "client")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "expositor")
    private Set<InvoiceCorrection> invoicesCorrectionExpositor;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "user")
    private Set<ResponseToTicket> responsesToTicket;

    @OneToOne(mappedBy = "user", optional = false, cascade = CascadeType.REMOVE)
    private UserDetails userDetails;

    public Integer getIdUser() {
        return idUser;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User setEnabledAccount(Boolean enabledAccount) {
        this.enabledAccount = enabledAccount;
        return this;
    }

    public Boolean isEnabledAccount() {
        return enabledAccount;
    }

    public User setRole(Role idRole) {
        this.role = idRole;
        return this;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser + '\'' +
                "firstName=" + firstName + '\'' +
                "lastName=" + lastName + '\'' +
                "email=" + email + '\'' +
                "passwordHash=" + passwordHash + '\'' +
                "enabledAccount=" + enabledAccount + '\'' +
                "idRole=" + role + '\'' +
                '}';
    }
}

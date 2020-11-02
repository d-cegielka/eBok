package pl.ebok.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @GeneratedValue
    @Id
    private Integer userId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean enabled;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<UserConsumerDetails> userConsumerDetails;

    @OneToMany(mappedBy = "user")
    private List<UserConsumerDetails> userBusinessDetails;

    @OneToMany(mappedBy = "user")
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoicesClients;

    @OneToMany(mappedBy = "expositor")
    private List<Invoice> invoicesExpositors;

    @OneToMany(mappedBy = "client")
    private List<Payment> payments;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "respondingUser")
    private List<ResponseToTicket> responses;

    public Integer getUserId() {
        return userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<UserConsumerDetails> getUserConsumerDetails() {
        return userConsumerDetails;
    }

    public void setUserConsumerDetails(List<UserConsumerDetails> userConsumerDetails) {
        this.userConsumerDetails = userConsumerDetails;
    }

    public List<UserConsumerDetails> getUserBusinessDetails() {
        return userBusinessDetails;
    }

    public void setUserBusinessDetails(List<UserConsumerDetails> userBusinessDetails) {
        this.userBusinessDetails = userBusinessDetails;
    }

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(List<Agreement> agreements) {
        this.agreements = agreements;
    }

    public List<Invoice> getInvoicesClients() {
        return invoicesClients;
    }

    public void setInvoicesClients(List<Invoice> invoicesClients) {
        this.invoicesClients = invoicesClients;
    }

    public List<Invoice> getInvoicesExpositors() {
        return invoicesExpositors;
    }

    public void setInvoicesExpositors(List<Invoice> invoicesExpositors) {
        this.invoicesExpositors = invoicesExpositors;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<ResponseToTicket> getResponses() {
        return responses;
    }

    public void setResponses(List<ResponseToTicket> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", userRole=" + role +
                '}';
    }
}

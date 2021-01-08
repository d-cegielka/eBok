package pl.ebok.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "`user`")
@NamedStoredProcedureQuery(name = "User.addUser",
procedureName = "sp_add_user", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "firstName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "lastName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "enabledAccount", type = Boolean.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "businessAccount", type = Boolean.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "companyName", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "taxId", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "phoneNumber", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "address", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "zipCode", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "city", type = String.class),
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

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "is_business_account", nullable = false)
    private Boolean businessAccount;

    @Column(name = "company_name", length = 40)
    private String companyName;

    @Column(name = "tax_id", length = 11, nullable = false)
    private String taxId;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "address", length = 40, nullable = false)
    private String address;

    @Column(name = "zip_code", length = 6, nullable = false)
    private String zipCode;

    @Column(name = "city", length = 25, nullable = false)
    private String city;

    @Column(name = "account_balance")
    private Double accountBalance;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Invoice> invoicesClient;

    @OneToMany(mappedBy = "expositor")
    private Set<Invoice> invoicesExpositor;

    @OneToMany(mappedBy = "user")
    private Set<Agreement> agreements;

    @OneToMany(mappedBy = "expositor")
    private Set<InvoiceCorrection> invoicesCorrectionExpositor;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;

    @OneToMany(mappedBy = "user")
    private Set<ResponseToTicket> responsesToTicket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    public User() {
    }

    public User(String firstName, String lastName, String email, String passwordHash, Boolean enabledAccount, Boolean businessAccount, String companyName, String taxId, String phoneNumber, String address, String zipCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.enabledAccount = enabledAccount;
        this.businessAccount = businessAccount;
        this.companyName = companyName;
        this.taxId = taxId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, firstName, lastName);
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Boolean getEnabledAccount() {
        return enabledAccount;
    }

    public void setEnabledAccount(Boolean enabledAccount) {
        this.enabledAccount = enabledAccount;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getBusinessAccount() {
        return businessAccount;
    }

    public void setBusinessAccount(Boolean businessAccount) {
        this.businessAccount = businessAccount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", enabledAccount=" + enabledAccount +
                ", registrationDate=" + registrationDate +
                ", businessAccount=" + businessAccount +
                ", companyName='" + companyName + '\'' +
                ", taxId='" + taxId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}

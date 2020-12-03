package pl.ebok.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_details", nullable = false)
    private Integer idUserDetails;

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

    @OneToOne
    @JoinColumn(name = "id_user_details")
    private User user;

    public UserDetails setIdUserDetails(Integer idUserDetails) {
        this.idUserDetails = idUserDetails;
        return this;
    }

    public Integer getIdUserDetails() {
        return idUserDetails;
    }

    public UserDetails setBusinessAccount(Boolean businessAccount) {
        this.businessAccount = businessAccount;
        return this;
    }

    public Boolean isBusinessAccount() {
        return businessAccount;
    }

    public UserDetails setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public UserDetails setTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public String getTaxId() {
        return taxId;
    }

    public UserDetails setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDetails setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDetails setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public UserDetails setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "idUserDetails=" + idUserDetails + '\'' +
                "businessAccount=" + businessAccount + '\'' +
                "companyName=" + companyName + '\'' +
                "taxId=" + taxId + '\'' +
                "phoneNumber=" + phoneNumber + '\'' +
                "address=" + address + '\'' +
                "zipCode=" + zipCode + '\'' +
                "city=" + city + '\'' +
                '}';
    }
}

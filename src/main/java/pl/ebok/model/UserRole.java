package pl.ebok.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRole {
    @GeneratedValue
    @Id
    private int userRoleId;

    @Column
    private String name;

    @OneToMany(mappedBy = "userRole")
    private List<User> users;
}

package pl.ebok.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Privilege {
    @GeneratedValue
    @Id
    private Integer permissionId;

    @Column
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}

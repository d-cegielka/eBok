package pl.ebok.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @GeneratedValue
    @Id
    private Integer roleId;

    @Column
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @ManyToMany
    private List<Privilege> privileges;

    public Integer getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

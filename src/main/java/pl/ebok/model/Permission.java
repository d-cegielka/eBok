package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permission")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission", nullable = false)
    private Integer idPermission;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    public void setIdPermission(Integer idPrivilege) {
        this.idPermission = idPrivilege;
    }

    public Integer getIdPermission() {
        return idPermission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "idPrivilege=" + idPermission + '\'' +
                "name=" + name + '\'' +
                '}';
    }
}

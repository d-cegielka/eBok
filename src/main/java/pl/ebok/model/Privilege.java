package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "privilege")
public class Privilege implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_privilege", nullable = false)
    private Integer idPrivilege;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    public void setIdPrivilege(Integer idPrivilege) {
        this.idPrivilege = idPrivilege;
    }

    public Integer getIdPrivilege() {
        return idPrivilege;
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
                "idPrivilege=" + idPrivilege + '\'' +
                "name=" + name + '\'' +
                '}';
    }
}

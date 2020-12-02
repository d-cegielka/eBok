package pl.ebok.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_privilege")
public class RolePrivilege implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role_privilege", nullable = false)
    private Integer idRolePrivilege;

    @Column(name = "id_role", nullable = false)
    private Integer idRole;

    @Column(name = "id_privilege", nullable = false)
    private Integer idPrivilege;

    public void setIdRolePrivilege(Integer idRolePrivilege) {
        this.idRolePrivilege = idRolePrivilege;
    }

    public Integer getIdRolePrivilege() {
        return idRolePrivilege;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdPrivilege(Integer idPrivilege) {
        this.idPrivilege = idPrivilege;
    }

    public Integer getIdPrivilege() {
        return idPrivilege;
    }

    @Override
    public String toString() {
        return "RolePrivilege{" +
                "idRolePrivilege=" + idRolePrivilege + '\'' +
                "idRole=" + idRole + '\'' +
                "idPrivilege=" + idPrivilege + '\'' +
                '}';
    }
}

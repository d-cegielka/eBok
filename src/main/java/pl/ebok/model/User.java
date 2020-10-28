package pl.ebok.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @GeneratedValue
    @Id
    private int user_id;

    @Column
    private String firstname;

    @Column
    private String lastname;
}

package ru.chuikov.ObrReiting.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name="rights_id",  nullable = false)
    private Right right_id;

    @Column(name = "family")
    private String family;

    @Column(name = "token")
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Right getRight() {
        return right_id;
    }

    public void setRight(Right right) {
        this.right_id = right;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User() {
    }

    public User(Right right) {
        this.right_id = right;
    }

    public User(Right right, String family) {
        this.right_id = right;
        this.family = family;
    }

    public User(Right right, String family, String token) {
        this.right_id = right;
        this.family = family;
        this.token = token;
    }

}

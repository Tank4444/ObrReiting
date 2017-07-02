package ru.chuikov.ObrReiting.entity;

import javax.persistence.*;

@Entity
@Table(name = "usersGroups")
public class UserGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroup() {
    }

    public UserGroup(String name) {
        this.name = name;
    }
}

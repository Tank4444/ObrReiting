package ru.chuikov.ObrReiting.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chairs")
public class Chair {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "chairs")
    private Set<Institute> institutes;

    //Getters and Setters
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
    public Set<Institute> getInstitutes() {
        return institutes;
    }
    public void setInstitutes(Set<Institute> institutes) {
        this.institutes = institutes;
    }

    //Contractors
    public Chair(String name, Set<Institute> institutes) {
        this.name = name;
        this.institutes = institutes;
    }
    public Chair(Set<Institute> institutes) {

        this.institutes = institutes;
    }
    public Chair(String name) {

        this.name = name;
    }
    public Chair() {

    }
}

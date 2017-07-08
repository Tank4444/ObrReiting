package ru.chuikov.ObrReiting.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "institutes")
public class Institute {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "city")
    private String city;

    @OneToOne(optional = true)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "institutes_chairs",
    joinColumns = @JoinColumn(name = "institutes_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "chairs_id",referencedColumnName = "id"))
    private List<Chair> chairs;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "teachers_id")
    private List<Teacher> teachers;

    //Gettesr and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Chair> getChairs() {
        return chairs;
    }
    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }
    public List<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Contractors
    public Institute(User user) {

        this.user = user;
    }
    public Institute(String city, User user, String address) {

        this.city = city;
        this.user = user;
        this.address = address;
    }
    public Institute(String city, User user) {

        this.city = city;
        this.user = user;
    }
    public Institute(String city) {

        this.city = city;
    }
    public Institute() {

    }
}

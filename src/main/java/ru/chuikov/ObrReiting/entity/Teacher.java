package ru.chuikov.ObrReiting.entity;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "institutes_id",nullable = false)
    private Institute institute;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chairs_id",nullable = false)
    private Chair chair;

    @Column(name = "fistname")
    private String fistName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "secondname")
    private String secondName;

    @ManyToOne(optional = true)
    @JoinColumn(name="users_id")
    private User user;

    //Getters and Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Institute getInstitute() {
        return institute;
    }
    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
    public Chair getChair() {
        return chair;
    }
    public void setChair(Chair chair) {
        this.chair = chair;
    }
    public String getFistName() {
        return fistName;
    }
    public void setFistName(String fistName) {
        this.fistName = fistName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //Constructors
    public Teacher(User user) {
        this.user = user;
    }
    public Teacher(Chair chair) {

        this.chair = chair;
    }
    public Teacher(String fistName, String lastName, String secondName) {

        this.fistName = fistName;
        this.lastName = lastName;
        this.secondName = secondName;
    }
    public Teacher(Institute institute, Chair chair, String fistName, String lastName, String secondName, User user) {

        this.institute = institute;
        this.chair = chair;
        this.fistName = fistName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.user = user;
    }
    public Teacher(Institute institute, Chair chair, String fistName, String lastName, String secondName) {

        this.institute = institute;
        this.chair = chair;
        this.fistName = fistName;
        this.lastName = lastName;
        this.secondName = secondName;
    }
    public Teacher(Institute institute, Chair chair, String fistName, String lastName) {

        this.institute = institute;
        this.chair = chair;
        this.fistName = fistName;
        this.lastName = lastName;
    }
    public Teacher(Institute institute, Chair chair, String fistName) {

        this.institute = institute;
        this.chair = chair;
        this.fistName = fistName;
    }
    public Teacher(Institute institute, Chair chair) {

        this.institute = institute;
        this.chair = chair;
    }
    public Teacher(Institute institute) {

        this.institute = institute;
    }
    public Teacher() {

    }
}

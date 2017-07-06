package ru.chuikov.ObrReiting.entity.keys;

import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.User;

import javax.persistence.Embeddable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class InstitutionsRaitongKeys implements Serializable{
    @ManyToOne
    @JoinColumn(name = "users_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "institutes_id",nullable = false)
    private Institute institute;

    //Get and Set
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Institute getInstitute() {
        return institute;
    }
    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    //Const
    public InstitutionsRaitongKeys(User user, Institute institute) {
        this.user = user;
        this.institute = institute;
    }
    public InstitutionsRaitongKeys(Institute institute) {

        this.institute = institute;
    }
    public InstitutionsRaitongKeys(User user) {

        this.user = user;
    }
    public InstitutionsRaitongKeys() {

    }
}

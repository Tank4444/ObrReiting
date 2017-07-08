package ru.chuikov.ObrReiting.entity;

import ru.chuikov.ObrReiting.entity.keys.InstitutionsRaitongKeys;

import javax.persistence.*;

@Entity
@Table(name = "institutesRatings")
@IdClass(InstitutionsRaitongKeys.class)
public class InstitutesRating {
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "user",column = @Column(name = "users_id")),
            @AttributeOverride(name = "institute",column = @Column(name = "institutes_id"))
    })
    private User user;
    private Institute institute;

    @Column(name = "mark")
    private int mark;

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
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    //Const
    public InstitutesRating(User user, int mark) {
        this.user = user;
        if(mark<0)this.mark=0;
        else if(mark>10)this.mark=10;
        else this.mark=mark;
    }
    public InstitutesRating(Institute institute, int mark) {

        this.institute = institute;
        if(mark<0)this.mark=0;
        else if(mark>10)this.mark=10;
        else this.mark=mark;
    }
    public InstitutesRating(User user, Institute institute) {

        this.user = user;
        this.institute = institute;
    }
    public InstitutesRating(int mark) {

        if(mark<0)this.mark=0;
        else if(mark>10)this.mark=10;
        else this.mark=mark;
    }
    public InstitutesRating(Institute institute) {

        this.institute = institute;
    }
    public InstitutesRating(User user) {

        this.user = user;
    }
    public InstitutesRating() {

    }
}

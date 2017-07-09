package ru.chuikov.ObrReiting.entity;


import javax.persistence.*;

@Entity
@Table(name = "institutesReviews")
public class InstitutesReview {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;


    @ManyToOne(optional = false)
    @JoinColumn(name="users_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name="institutes_id")
    private Institute institute;

    @Column(name = "text")
    private String text;
    @Column(name = "moderated")
    private boolean moderated=false;

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
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public boolean isModerated() {
        return moderated;
    }
    public void setModerated(boolean moderated) {
        this.moderated = moderated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Const
    public InstitutesReview(User user, Institute institute, String text, boolean moderated) {
        this.user = user;
        this.institute = institute;
        this.text = text;
        this.moderated = moderated;
    }
    public InstitutesReview(User user, Institute institute, String text) {

        this.user = user;
        this.institute = institute;
        this.text = text;
    }
    public InstitutesReview(User user, Institute institute) {

        this.user = user;
        this.institute = institute;
    }
    public InstitutesReview(User user) {

        this.user = user;
    }
    public InstitutesReview() {

    }
}

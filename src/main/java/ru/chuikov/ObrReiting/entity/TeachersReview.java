package ru.chuikov.ObrReiting.entity;

import javafx.beans.DefaultProperty;
import ru.chuikov.ObrReiting.entity.keys.TeachersRatingKeys;

import javax.persistence.*;

@Entity
@Table(name = "teachersReviews")
@IdClass(TeachersRatingKeys.class)
public class TeachersReview {
    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "user",column = @Column(name = "users_id")),
            @AttributeOverride(name = "teacher",column = @Column(name = "teachers_id"))
    })
    private User user;
    private Teacher teacher;

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
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    //Const
    public TeachersReview(User user, Teacher teacher, String text, boolean moderated) {
        this.user = user;
        this.teacher = teacher;
        this.text = text;
        this.moderated = moderated;
    }
    public TeachersReview(User user, Teacher teacher, String text) {

        this.user = user;
        this.teacher = teacher;
        this.text = text;
    }
    public TeachersReview(User user, Teacher teacher) {

        this.user = user;
        this.teacher = teacher;
    }
    public TeachersReview(User user) {

        this.user = user;
    }
    public TeachersReview() {

    }
}

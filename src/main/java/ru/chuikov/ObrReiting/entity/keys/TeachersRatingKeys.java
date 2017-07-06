package ru.chuikov.ObrReiting.entity.keys;


import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.entity.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class TeachersRatingKeys implements Serializable {
    @ManyToOne
    @JoinColumn(name = "users_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "teachers_id",nullable = false)
    private Teacher teacher;

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

    //Const
    public TeachersRatingKeys(Teacher teacher) {
        this.teacher = teacher;
    }
    public TeachersRatingKeys(User user, Teacher teacher) {

        this.user = user;
        this.teacher = teacher;
    }
    public TeachersRatingKeys(User user) {

        this.user = user;
    }
    public TeachersRatingKeys() {

    }
}

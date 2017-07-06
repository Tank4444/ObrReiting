package ru.chuikov.ObrReiting.entity;

import ru.chuikov.ObrReiting.entity.keys.TeachersRatingKeys;

import javax.persistence.*;

@Entity
@Table(name = "teachersRatings")
@IdClass(TeachersRatingKeys.class)
public class TeachersRating {

    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "user",column = @Column(name = "users_id")),
            @AttributeOverride(name = "teacher",column = @Column(name = "teachers_id"))
    })
    private User user;
    private Teacher teacher;

    @Column(name = "mark")
    private int mark;

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
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    //Const
    public TeachersRating(User user, Teacher teacher, int mark) {
        this.user = user;
        this.teacher = teacher;
        this.mark = mark;
    }
    public TeachersRating(User user, Teacher teacher) {
        this.user = user;
        this.teacher = teacher;
    }
    public TeachersRating(int mark) {

        this.mark = mark;
    }
    public TeachersRating(Teacher teacher) {

        this.teacher = teacher;
    }
    public TeachersRating(User user) {

        this.user = user;
    }
    public TeachersRating() {

    }
}

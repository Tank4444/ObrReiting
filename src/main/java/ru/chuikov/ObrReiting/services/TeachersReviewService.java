package ru.chuikov.ObrReiting.services;

import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.entity.TeachersReview;
import ru.chuikov.ObrReiting.entity.User;

import java.util.List;


public interface TeachersReviewService {
    TeachersReview addReview(TeachersReview teachersReview);
    TeachersReview editReview(TeachersReview  teachersReview);
    List<TeachersReview> getAll();
    List<TeachersReview> getModerated();
    List<TeachersReview> getUnModerated();
    List<TeachersReview> getByUser(User user);
    List<TeachersReview> getByTeacher(Teacher teacher);
    TeachersReview getByUserAndTeacher(User user, Teacher teacher);
}

package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.entity.TeachersRating;
import ru.chuikov.ObrReiting.entity.User;

import java.util.List;

public interface TeachersRatingService {
    TeachersRating addInstitutesRating(TeachersRating teachersRating);
    TeachersRating getByUserAndTeacher(User user, Teacher teacher);
    List<TeachersRating> getByUser(User user);
    List<TeachersRating> getByInstitute(Teacher teacher);
    TeachersRating editTeachersRating(TeachersRating teachersRating);
    List<TeachersRating> getAll();
}

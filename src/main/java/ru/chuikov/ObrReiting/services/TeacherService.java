package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Chair;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);
    void delete(long id);
    Teacher editTeacher(Teacher teacher);
    List<Teacher> getAll();
    List<Teacher> getByInstitutes(Institute institute);
    List<Teacher> getByChair(Chair chair);
    Teacher getById(long id);
}

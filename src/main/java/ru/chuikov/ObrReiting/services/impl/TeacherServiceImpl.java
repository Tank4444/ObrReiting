package ru.chuikov.ObrReiting.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.Chair;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.repository.TeacherRepository;
import ru.chuikov.ObrReiting.services.TeacherService;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    public void delete(long id) {
        teacherRepository.delete(id);
    }

    public Teacher editTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getByInstitutes(Institute institute) {
        return teacherRepository.findByInstitute(institute);
    }

    public List<Teacher> getByChair(Chair chair) {
        return teacherRepository.findByChair(chair);
    }

    public Teacher getById(long id) {
        return teacherRepository.findById(id);
    }
}

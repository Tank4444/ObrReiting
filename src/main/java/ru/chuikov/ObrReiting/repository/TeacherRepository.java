package ru.chuikov.ObrReiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Chair;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.entity.User;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query("select b from Teacher b where b.id = :id ")
    Teacher findById(@Param("id") long id);

    @Query("select b from Teacher b where b.institute = :iname ")
    List<Teacher> findByInstitute(@Param("iname")Institute institute);

    @Query("select b from Teacher b where b.chair = :cname ")
    List<Teacher> findByChair(@Param("cname")Chair chair);

    @Query("select b from Teacher b where b.user = :uname ")
    Teacher findByUser(@Param("uname")User user);

    @Query("select b from Teacher b where b.fistName = :fname ")
    List<Teacher> findByFistName(@Param("fname") String fname);

    @Query("select b from Teacher b where b.lastName = :lname ")
    List<Teacher> findByLastName(@Param("lname") String lname);

    @Query("select b from Teacher b where b.secondName = :sname ")
    List<Teacher> findBySecondName(@Param("sname") String sname);

    @Query("select b from Teacher b where b.secondName = :sname and b.fistName = :fname and b.lastName = :lname")
    List<Teacher> findByFullName(@Param("fname") String fname,@Param("lname") String lname,@Param("sname") String sname);
}

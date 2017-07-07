package ru.chuikov.ObrReiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.entity.TeachersRating;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.entity.keys.TeachersRatingKeys;

import java.util.List;

public interface TeachersRatingRepository extends JpaRepository<TeachersRating,TeachersRatingKeys> {

    @Query("select b from TeachersRating b where b.user = :name")
    List<TeachersRating> findByUser(@Param("name")User user);

    @Query("select b from TeachersRating b where b.teacher = :name")
    List<TeachersRating> findByTeacher(@Param("name")Teacher teacher);

    @Query("select b from TeachersRating b where b.user=:uname and b.teacher=:tname")
    TeachersRating findByUserAndTeacher(@Param("uname") User user,@Param("tname") Teacher teacher);
}

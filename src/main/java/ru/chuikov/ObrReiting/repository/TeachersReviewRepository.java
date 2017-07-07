package ru.chuikov.ObrReiting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.entity.TeachersReview;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.entity.keys.TeachersRatingKeys;

import java.util.List;


public interface TeachersReviewRepository extends JpaRepository<TeachersReview,TeachersRatingKeys> {
    @Query("select b from TeachersReview b where b.user= :name ")
    List<TeachersReview> findByUser(@Param("name")User user);

    @Query("select b from TeachersReview b where b.teacher = :name")
    List<TeachersReview> findByTeacher(@Param("name")Teacher teacher);

    @Query("select b from TeachersReview b where b.user=:uname and b.teacher=:iname")
    TeachersReview findByUserAndTeacher(@Param("uname") User user,@Param("iname") Teacher teacher);

    @Query("select b from TeachersReview b where b.moderated = true ")
    List<TeachersReview> findByModerated();
    @Query("select b from TeachersReview b where b.moderated = false ")
    List<TeachersReview> findByUnModerated();
}

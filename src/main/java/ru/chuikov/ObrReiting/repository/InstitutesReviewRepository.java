package ru.chuikov.ObrReiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesReview;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.entity.keys.InstitutionsRaitongKeys;

import java.util.List;

public interface InstitutesReviewRepository extends JpaRepository<InstitutesReview,InstitutionsRaitongKeys> {

    @Query("select b from InstitutesReview b where b.user = :name")
    List<InstitutesReview> findByUser(@Param("name")User user);

    @Query("select b from InstitutesReview b where b.institute = :name")
    List<InstitutesReview> findByInstitute(@Param("name")Institute institute);

    @Query("select b from InstitutesReview b where b.user=:uname and b.institute=:iname")
    InstitutesReview findByUserAndInstitute(@Param("uname") User user,@Param("iname") Institute institute);

    @Query("select b from InstitutesReview b where b.moderated = true ")
    List<InstitutesReview> findByModerated();
    @Query("select b from InstitutesReview b where b.moderated = false ")
    List<InstitutesReview> findByUnModerated();
}

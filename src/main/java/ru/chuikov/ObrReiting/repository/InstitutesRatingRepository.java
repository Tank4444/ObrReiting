package ru.chuikov.ObrReiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesRating;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.entity.keys.InstitutionsRaitongKeys;

import java.util.List;

public interface InstitutesRatingRepository extends JpaRepository<InstitutesRating,Long> {
    @Query("select b from InstitutesRating b where b.id = :id")
    InstitutesRating findById(@Param("id") long id);
    @Query("select b from InstitutesRating b where b.user = :name")
    List<InstitutesRating> findByUser(@Param("name")User user);

    @Query("select b from InstitutesRating b where b.institute = :name")
    List<InstitutesRating> findByInstitute(@Param("name")Institute institute);

    @Query("select b from InstitutesRating b where b.user = :uname and b.institute = :iname")
    List<InstitutesRating>  findByUserAndInstitute(@Param("uname") User user,@Param("iname") Institute institute);
}

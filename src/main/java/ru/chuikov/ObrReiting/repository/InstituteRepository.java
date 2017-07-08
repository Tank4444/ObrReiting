package ru.chuikov.ObrReiting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Chair;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.Teacher;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.entity.keys.InstitutionsRaitongKeys;

import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute,Long> {

    @Query("select b from Institute b where b.name = :name")
    List<Institute> findByName(@Param("name") String name);

    @Query("select b from Institute b where b.id = :id")
    Institute findById(@Param("id") long id);

    @Query("select b from Institute b where b.city = :city")
    List<Institute> findByCity(@Param("city") String city);

    @Query("select b from Institute b where b.user = :uname")
    Institute findByUser(@Param("uname") User user);

    @Query("select b from Institute b where b.teachers = :tname")
    List<Institute> findByTeacher(@Param("tname")Teacher teacher);

    @Query("select b from Institute b where b.chairs = :cname")
    List<Institute> findByChair(@Param("cname")Chair chair);

    @Query("select b from Institute b where b.address = :aname")
    List<Institute> findByAddress(@Param("aname") String aname);

    @Query("select b from Institute b where b.address = :aname and b.city=:cname")
    List<Institute> findByCityAndAddress(@Param("aname") String aname,@Param("cname") String cname);

    @Query("select b from Institute b where b.name = :name and b.city=:cname")
    List<Institute> findByNameAndCity(@Param("name") String name,@Param("cname") String cname);
}

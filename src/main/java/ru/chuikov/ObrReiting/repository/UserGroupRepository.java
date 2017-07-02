package ru.chuikov.ObrReiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Right;
import ru.chuikov.ObrReiting.entity.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup,Long> {
    @Query("select b from UserGroup b where b.name = :name")
    UserGroup findByName(@Param("name") String name);
    @Query("select b from UserGroup b where b.id = :id")
    UserGroup findById(@Param("id") long id);
}

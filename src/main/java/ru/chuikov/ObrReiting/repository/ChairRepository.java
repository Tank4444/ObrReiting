package ru.chuikov.ObrReiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Chair;

public interface ChairRepository extends JpaRepository<Chair,Long> {
    @Query("select b from Chair b where b.name = :name")
    Chair findByName(@Param("name") String name);

    @Query("select b from Chair b where b.id = :id")
    Chair findById(@Param("id") long id);
}

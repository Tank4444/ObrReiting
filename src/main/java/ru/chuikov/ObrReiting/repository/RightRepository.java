package ru.chuikov.ObrReiting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.Right;

public interface RightRepository extends JpaRepository<Right,Long>{

    @Query("select b from Right b where b.name = :name")
    Right findByName(@Param("name") String name);

    @Query("select b from Right b where b.id = :id")
    Right findById(@Param("id") long id);
}

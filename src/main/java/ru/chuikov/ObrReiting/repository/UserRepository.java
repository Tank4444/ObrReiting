package ru.chuikov.ObrReiting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chuikov.ObrReiting.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    //token
    @Query("select b from User b where b.token = :token")
    User findByToken(@Param("token") String token);
    //id
    @Query("select b from User b where b.id = :id")
    User findById(@Param("id") long id);
    //login
    @Query("select b from User b where b.login = :login")
    User findByLogin(@Param("login") String login);
    //mail
    @Query("select b from User b where b.mail = :mail")
    User findByMail(@Param("mail") String mail);
}

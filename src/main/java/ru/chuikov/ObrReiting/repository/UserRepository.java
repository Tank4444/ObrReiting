package ru.chuikov.ObrReiting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chuikov.ObrReiting.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}

package ru.chuikov.ObrReiting.services;



import ru.chuikov.ObrReiting.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getByLogin(String login);
    User getByToken(String token);
    User getByMail(String mail);
    User getById(long id);
    User editUser(User user);
    List<User> getAll();
}

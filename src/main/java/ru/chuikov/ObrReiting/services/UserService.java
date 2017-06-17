package ru.chuikov.ObrReiting.services;



import ru.chuikov.ObrReiting.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User right);
    void delete(long id);
    User getByName(String name);
    User getById(long id);
    User editUser(User right);
    List<User> getAll();
}

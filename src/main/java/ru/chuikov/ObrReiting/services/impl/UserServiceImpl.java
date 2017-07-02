package ru.chuikov.ObrReiting.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.repository.UserRepository;
import ru.chuikov.ObrReiting.services.UserService;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void delete(long id) {
        userRepository.delete(id);
    }

    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User getByToken(String token) {
        return userRepository.findByToken(token);
    }

    public User getByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    public User getById(long id) {
        return userRepository.findById(id);
    }

    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}

package ru.chuikov.ObrReiting.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.UserGroup;
import ru.chuikov.ObrReiting.repository.UserGroupRepository;
import ru.chuikov.ObrReiting.services.UserGroupService;

import java.util.List;

@Service("UserGroupService")
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    public UserGroup addUserGroup(UserGroup group) {
        return userGroupRepository.saveAndFlush(group);
    }

    public void delete(long id) {
        userGroupRepository.delete(id);
    }

    public UserGroup getByName(String name) {
        return userGroupRepository.findByName(name);
    }

    public UserGroup getById(long id) {
        return userGroupRepository.findById(id);
    }

    public UserGroup editUserGroup(UserGroup group) {
        return userGroupRepository.saveAndFlush(group);
    }

    public List<UserGroup> getAll() {
        return userGroupRepository.findAll();
    }
}

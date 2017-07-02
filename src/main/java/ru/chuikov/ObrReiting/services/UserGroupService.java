package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.UserGroup;

import java.util.List;

public interface UserGroupService {
    UserGroup addUserGroup(UserGroup group);
    void delete(long id);
    UserGroup getByName(String name);
    UserGroup getById(long id);
    UserGroup editUserGroup(UserGroup group);
    List<UserGroup> getAll();
}

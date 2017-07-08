package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.ObrReiting.entity.Right;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.entity.UserGroup;
import ru.chuikov.ObrReiting.services.impl.RightServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserGroupServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserServiceImpl;

import java.util.HashMap;

@RestController
@RequestMapping("test")
public class TestRest {

    @Autowired
    private UserGroupServiceImpl userGroupService;
    @Autowired
    private RightServiceImpl rightService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public HashMap getOK()
    {
        rightService.addRight(new Right("USER"));
        rightService.addRight(new Right("MODERATOR"));
        rightService.addRight(new Right("ADMINISTRATOR"));

        userGroupService.addUserGroup(new UserGroup("STUDENTS"));
        userGroupService.addUserGroup(new UserGroup("TEACHERS"));
        userGroupService.addUserGroup(new UserGroup("INSTITUTIONS"));
        userGroupService.addUserGroup(new UserGroup("MODERATORS"));

        userService.addUser(new User(rightService.getByName("USER"),userGroupService.getByName("STUDENTS"),
                "token","Anton","anton","anton@mail.ru"));
        userService.addUser(new User(rightService.getByName("USER"),userGroupService.getByName("INSTITUTIONS"),
                "token","altgtu","1234","mail.ru"));

        HashMap hm=new HashMap();
        hm.put("result","OK");
        return hm;
    }
}

package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.services.impl.RightServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserGroupServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user",produces = "application/json")
public class UserController {
    @Autowired
    private UserGroupServiceImpl userGroupService;
    @Autowired
    private RightServiceImpl rightService;
    @Autowired
    private UserServiceImpl userService;

    private String login="login";
    private String password="password";
    private String token="token";
    private String mail="mail";
    private int inc=1;
    @RequestMapping(method = RequestMethod.GET)
    public List<User> start()
    {
        //add user with Right User
        userService.addUser(new User(rightService.getByName("USER"),userGroupService.getByName("STUDENTS"),login,password,token,mail));
        login=login+" "+inc;
        password=password+" "+inc;
        token=token+" "+inc;
        mail=mail+" "+inc;
        inc++;
        userService.addUser(new User(rightService.getByName("MODERATOR"),userGroupService.getByName("TEACHERS"),login,password,token,mail));
        login=login+" "+inc;
        password=password+" "+inc;
        token=token+" "+inc;
        mail=mail+" "+inc;
        inc++;
        userService.addUser(new User(rightService.getByName("USER"),userGroupService.getByName("STUDENTS"),login,password,token,mail));

        return userService.getAll();
    }
    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<User> show()
    {
        return userService.getAll();
    }

}

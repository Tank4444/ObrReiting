package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.ObrReiting.entity.UserGroup;
import ru.chuikov.ObrReiting.services.impl.UserGroupServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/group",produces = "application/json")
public class UserGroupController {
    @Autowired
    private UserGroupServiceImpl userGroupService;

    @RequestMapping(method = RequestMethod.GET)
    public void start()
    {
        userGroupService.addUserGroup(new UserGroup("STUDENTS"));
        userGroupService.addUserGroup(new UserGroup("TEACHERS"));
        userGroupService.addUserGroup(new UserGroup("INSTITUTIONS"));
        userGroupService.addUserGroup(new UserGroup("MODERATORS"));
    }
    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<UserGroup> show()
    {
        return userGroupService.getAll();
    }

    @RequestMapping(path = "/getById",method = RequestMethod.GET)
    public UserGroup getRbyId(@RequestParam("id") int id){
        return userGroupService.getById(id);
    }
    @RequestMapping(path = "/getByName",method = RequestMethod.GET)
    public UserGroup getRbyId(@RequestParam("name") String name){
        return userGroupService.getByName(name);
    }
}

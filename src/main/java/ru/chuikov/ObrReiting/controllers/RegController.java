package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.services.impl.RightServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserGroupServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserServiceImpl;

@Controller
@RequestMapping("/reg")
public class RegController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserGroupServiceImpl userGroupService;
    @Autowired
    private RightServiceImpl rightService;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView regGet()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String regPost(@RequestParam("login") String login,@RequestParam("password")String password,
                          @RequestParam("mail")String mail)
    {
        User user=new User();
        user.setGroup(userGroupService.getByName("STUDENTS"));
        user.setRight(rightService.getByName("USER"));
        user.setLogin(login);
        user.setPassword(password);
        user.setMail(mail);
        userService.addUser(user);
        return "OK";
    }
}

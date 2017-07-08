package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.chuikov.ObrReiting.entity.*;
import ru.chuikov.ObrReiting.services.impl.InstituteServiceImpl;
import ru.chuikov.ObrReiting.services.impl.InstitutesRatingServiceImpl;
import ru.chuikov.ObrReiting.services.impl.InstitutesReviewServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

@Controller
@RequestMapping(value = "/inst")
public class InstituteController {
    @Autowired
    private InstituteServiceImpl instituteService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private InstitutesReviewServiceImpl institutesReviewService;

    @Autowired
    private InstitutesRatingServiceImpl institutesRatingService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView show()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("inst");
        mav.addObject("list",instituteService.getAll());
        return mav;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addGet()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("instadd");
        return mav;
    }
    @RequestMapping(value = "/addInst", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(@RequestParam("city")String city,@RequestParam("login") String login,
                        @RequestParam("name")String name,@RequestParam("address")String address,HttpServletRequest request)
    {

        Institute in=new Institute();
        in.setCity(city);
        in.setUser(userService.getByLogin(login));
        in.setName(name);
        in.setAddress(address);
        in.setChairs(new HashSet<Chair>());
        in.setTeachers(new HashSet<Teacher>());
        instituteService.addInstitute(in);
        return "ок";
    }

    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
    public ModelAndView seeInst(@PathVariable long id)
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("instview");
        mav.addObject("inst",instituteService.getById(id));
        mav.addObject("listReview",institutesReviewService.getByInstitute(instituteService.getById(id)));
        mav.addObject("listRating",institutesRatingService.getByInstitute(instituteService.getById(id)));
        return mav;
    }
}

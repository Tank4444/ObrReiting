package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.chuikov.ObrReiting.entity.*;
import ru.chuikov.ObrReiting.services.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    @Autowired
    private ChairServiceImpl chairService;

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
        mav.addObject("listChair",chairService.getAll());
        return mav;
    }
    @RequestMapping(value = "/addInst", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(@RequestParam("city")String city,
                        @RequestParam("name")String name,@RequestParam("address")String address,
                          @RequestParam(value = "chair",required = false) long[] idChairs)
    {
        Institute in=new Institute();
        in.setCity(city);
        in.setName(name);
        in.setAddress(address);

        in.setTeachers(new HashSet<Teacher>());
        HashSet<Chair> chairs=new HashSet<Chair>();
        for(int i=0;i<idChairs.length;i++)
        {
            chairs.add(chairService.getById(idChairs[i]));
        }
        in.setChairs(chairs);
        instituteService.addInstitute(in);

        return "OK <br> <a href='/inst/view/" + in.getId() + "'>Отзывы</a>";
    }

    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
    public ModelAndView seeInst(@PathVariable long id)
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("instview");
        mav.addObject("inst",instituteService.getById(id));
        mav.addObject("listReview",institutesReviewService.getByInstitute(instituteService.getById(id)));
        mav.addObject("listRating",institutesRatingService.getByInstitute(instituteService.getById(id)));
        mav.addObject("listChairs",instituteService.getById(id).getChairs());
        return mav;
    }
}

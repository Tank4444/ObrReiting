package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.chuikov.ObrReiting.entity.*;
import ru.chuikov.ObrReiting.services.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

        in.setTeachers(new ArrayList<Teacher>() {
        });
        ArrayList<Chair> chairs=new ArrayList<Chair>();
        for(int i=0;i<idChairs.length;i++)
        {
            chairs.add(chairService.getById(idChairs[i]));
        }
        in.setChairs(chairs);
        instituteService.addInstitute(in);

        return "OK <br> <a href='/inst/view/" + in.getId() + "'>Отзывы</a>";
    }
    @RequestMapping(value = "/editInst", method = RequestMethod.POST)
    @ResponseBody
    public String editPost(@RequestParam("city")String city,@RequestParam("id") long id,
                          @RequestParam("name")String name,@RequestParam("address")String address,
                          @RequestParam(value = "chair",required = false) long[] idChairs)
    {
        Institute in=new Institute();
        in.setCity(city);
        in.setName(name);
        in.setAddress(address);
        in.setId(id);
        in.setTeachers(new ArrayList<Teacher>());
        ArrayList<Chair> chairs=new ArrayList<Chair>();
        for(int i=0;i<idChairs.length;i++)
        {
            chairs.add(chairService.getById(idChairs[i]));
        }
        in.setChairs(chairs);
        instituteService.editInstitute(in);

        return "OK <br> <a href='/inst/view/" + in.getId() + "'>Отзывы</a>";
    }

    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
    public ModelAndView seeInst(@PathVariable long id)
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("instview");
        int sred=institutesRatingService.getSrednee(instituteService.getById(id));
        mav.addObject("mark",sred);
        mav.addObject("inst",instituteService.getById(id));
        mav.addObject("listReview",institutesReviewService.getByInstitute(instituteService.getById(id)));
        mav.addObject("listRating",institutesRatingService.getByInstitute(instituteService.getById(id)));
        mav.addObject("listChairs",instituteService.getById(id).getChairs());
        return mav;
    }
    @RequestMapping(value = "/view/{id}/edit",method = RequestMethod.GET)
    public ModelAndView editInst(@PathVariable long id)
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("instadd");
        mav.addObject("edit",true);
        mav.addObject("inst",instituteService.getById(id));
        mav.addObject("listReview",institutesReviewService.getByInstitute(instituteService.getById(id)));
        mav.addObject("listRating",institutesRatingService.getByInstitute(instituteService.getById(id)));

        HashMap<Chair,String> chairStringHashMap=new HashMap<Chair, String>();
        List<Chair> allChair=chairService.getAll();
        List<Chair> usedChair=instituteService.getById(id).getChairs();
        int f=0;
        for (int i=0;i<allChair.size();i++)
        {
            f=0;
            for(int j=0;j<usedChair.size();j++)
            {
                if(allChair.get(i).getName().equals(usedChair.get(j).getName())){
                    f++;
                }
            }
            if(f==0){
                chairStringHashMap.put(allChair.get(i),"no");
            }else
            {
                chairStringHashMap.put(allChair.get(i),"yes");
            }
        }
        mav.addObject("listChairs",chairStringHashMap);
        return mav;
    }

}

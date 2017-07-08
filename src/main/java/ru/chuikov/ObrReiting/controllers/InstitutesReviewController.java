package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.chuikov.ObrReiting.entity.InstitutesRating;
import ru.chuikov.ObrReiting.entity.InstitutesReview;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.services.impl.InstituteServiceImpl;
import ru.chuikov.ObrReiting.services.impl.InstitutesRatingServiceImpl;
import ru.chuikov.ObrReiting.services.impl.InstitutesReviewServiceImpl;
import ru.chuikov.ObrReiting.services.impl.UserServiceImpl;
import java.util.List;

@Controller
@RequestMapping("/instReview")
public class InstitutesReviewController {
    @Autowired
    private InstitutesReviewServiceImpl institutesReviewService;
    @Autowired
    private InstituteServiceImpl instituteService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private InstitutesRatingServiceImpl institutesRatingService;

    @RequestMapping(method = RequestMethod.GET,value = "/add/{idInst}")
    public ModelAndView reviewGet(@PathVariable long idInst)
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("instreview");
        modelAndView.addObject("inst",instituteService.getById(idInst));
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST,value = "/add/{idInst}")
    @ResponseBody
    public String reviewPost(@PathVariable long idInst,
                             @RequestParam("text")String text,
                             @RequestParam("login")String login,
                             @RequestParam("password")String password,
                             @RequestParam("mark")int mark
                             )
    {
        User user=userService.getByLogin(login);
        if((!user.getPassword().equals(password))||(!user.getLogin().equals(login)))
        {
            return "Неправильный логин или пароль";
        }
        List<InstitutesReview> institutesReviews=institutesReviewService.getByUserAndInstitution(user,instituteService.getById(idInst));
        if(institutesReviews.size()>=1)
        {
            return "Отзыв уже есть";
        }


        institutesReviewService.addReview(new InstitutesReview(userService.getByLogin(login),
                instituteService.getById(idInst),text,false));

        InstitutesRating institutesRating=new InstitutesRating();
        institutesRating.setUser(user);
        institutesRating.setInstitute(instituteService.getById(idInst));
        institutesRating.setMark(mark);
        institutesRatingService.addInstitutesRating(institutesRating);

        return "OK <br> <a href='/inst/view/" + idInst + "'>Отзывы</a>";
    }
}

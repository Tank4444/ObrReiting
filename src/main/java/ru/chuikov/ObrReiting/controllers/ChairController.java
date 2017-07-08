package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.ObrReiting.entity.Chair;
import ru.chuikov.ObrReiting.services.impl.ChairServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/chair",produces = "application/json")
public class ChairController {
    @Autowired
    private ChairServiceImpl chairService;
    int i=0;

    @RequestMapping(method = RequestMethod.GET)
    public List<Chair> getAll()
    {
        if(i==0)
        {
            chairService.addChair(new Chair("Высшей математики"));
            chairService.addChair(new Chair("Высшей математики и математического моделирования"));
            chairService.addChair(new Chair("Информатики, вычислительной техники и информационной безопасности "));
            chairService.addChair(new Chair("Информационных систем в экономике"));
            chairService.addChair(new Chair("Информационных технологий"));
            chairService.addChair(new Chair("Прикладной математики"));
            chairService.addChair(new Chair("Защита информации в вычислительных системах"));
            i++;
        }
        return chairService.getAll();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/add")
    public List<Chair> add(@RequestParam("name")String name)
    {
        chairService.addChair(new Chair(name));
        return chairService.getAll();
    }
}

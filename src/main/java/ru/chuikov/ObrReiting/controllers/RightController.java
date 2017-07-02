package ru.chuikov.ObrReiting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.chuikov.ObrReiting.entity.Right;
import ru.chuikov.ObrReiting.services.RightService;
import ru.chuikov.ObrReiting.services.impl.RightServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/right",produces = "application/json")
public class RightController {
    @Autowired
    private RightServiceImpl rightService;

    private int testint=0;

    @RequestMapping(method = RequestMethod.GET)
    public void start()
    {
        rightService.addRight(new Right("USER"));
        rightService.addRight(new Right("MODERATOR"));
        rightService.addRight(new Right("ADMINISTRATOR"));
    }


    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<Right> show()
    {
        return rightService.getAll();
    }

    @RequestMapping(path = "/getById",method = RequestMethod.GET)
    public Right getRbyId(@RequestParam("id") int id){
        return rightService.getById(id);
    }
    @RequestMapping(path = "/getByName",method = RequestMethod.GET)
    public Right getRbyId(@RequestParam("name") String name){
        return rightService.getByName(name);
    }

}
